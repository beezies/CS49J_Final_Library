
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import org.json.JSONObject;
import org.json.JSONArray;
import org.apache.commons.io.IOUtils;

abstract class User implements Comparable<User> {

	public static void main(String[] args) {
		Member m = new Member("mmmm", "ell", "emm", "epp");

		m.openBook("CS-49J-notes");

	}

	protected String userName;
	protected String password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	abstract String getName();

	abstract String getUserName();

	abstract String getPassword();

	protected void openBook(String pdfName) {
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File(pdfName + ".pdf");
				Desktop.getDesktop().open(myFile);
			} catch (Exception ex) {
			}
		}
	}
}

class Member extends User {

	private String firstName;
	private String lastName;
	JSONObject memberJSON;
	JSONArray books;

	// New account
	public Member(String userName, String password, String firstName, String lastName) throws IllegalArgumentException {
		this.firstName = firstName;
		this.lastName = lastName;
		setUserName(userName);
		setPassword(password);

		memberJSON = new JSONObject();
		books = new JSONArray();

		addToFile();
	}

	// Quick constructor for login
	public Member(String userName, String password) {
		setUserName(userName);
		setPassword(password);
	}

	private void addToFile() throws IllegalArgumentException {

		try {
			InputStream is = new FileInputStream(UserHandler.getFileName());
			String memberFileText = IOUtils.toString(is, "UTF-8");
			JSONObject membersJSON = new JSONObject(memberFileText);
			JSONArray membersArray = membersJSON.getJSONArray("members");

			for (int i = 0; i < membersArray.length(); i++) {
				JSONObject member = membersArray.getJSONObject(i);
				String uname = member.getString("username");
				if (uname.equals(userName)) {
					throw new IllegalArgumentException();
				}
			}

			memberJSON.put("username", userName);
			memberJSON.put("password", password);
			memberJSON.put("first name", firstName);
			memberJSON.put("last name", lastName);
			memberJSON.put("books checked", books);

			membersArray.put(memberJSON);

			Files.write(UserHandler.getFilePath(), membersJSON.toString().getBytes(), StandardOpenOption.WRITE);
		} catch (Exception e1) {
			throw new IllegalArgumentException();
		}
	}

	public void checkout(String title, String author) {
		JSONObject book = new JSONObject();
		book.put("title", title);
		book.put("author", author);
		book.put("checkout date", LocalDate.now().toString());

		handleBook(book, "checkout");
	}

	public void returnBook(String title, String author) {

		JSONObject book = new JSONObject();
		book.put("title", title);
		book.put("author", author);
		book.put("checkout date", LocalDate.now().toString());

		handleBook(book, "return");
	}

	public void handleBook(JSONObject book, String action) {
		try {
			InputStream is = new FileInputStream(UserHandler.getFileName());
			String memberFileText = IOUtils.toString(is, "UTF-8");
			JSONObject membersJSON = new JSONObject(memberFileText);
			JSONArray membersArray = membersJSON.getJSONArray("members");

			for (int i = 0; i < membersArray.length(); i++) {

				memberJSON = membersArray.getJSONObject(i);
				String uname = memberJSON.getString("username");
				if (uname.equals(userName)) {
					books = memberJSON.getJSONArray("books checked");

					switch (action) {
					case "checkout":
						books.put(book);
						break;
					case "return":
						for (int j = 0; j < books.length(); j++) {
							JSONObject bookJSON = books.getJSONObject(j);
							String title = bookJSON.getString("title");
							String author = bookJSON.getString("author");
							if (title.equals(book.getString("title")) && author.equals(book.getString("author"))) {
								books.remove(j);
							}
						}
						break;
					case "open":
						openBook(book.getString("title") + book.getString("author"));
					}

				}
			}

			Files.write(UserHandler.getFilePath(), membersJSON.toString().getBytes(), StandardOpenOption.WRITE);
		} catch (Exception e1) {
		}
	}

	@Override
	String getName() {
		return firstName + " " + lastName;
	}

	@Override
	String getUserName() {
		return userName;
	}

	@Override
	String getPassword() {
		return password;
	}

	@Override
	public int compareTo(User o) {

		if (o == this)
			return 0;

		int nameDiff = (o.getName().compareTo(this.getName()));
		if (nameDiff > 0)
			return 1;
		else if (nameDiff < 0)
			return -1;

		int userNameDiff = (o.getUserName().compareTo(this.getUserName()));
		if (userNameDiff > 0)
			return 1;
		else if (userNameDiff < 0)
			return -1;

		return 0;
	}

}

class AdminUser extends User {

	private final String ADMIN_USER = "ADMIN";
	private final String ADMIN_PASS = "ADMIN";

	public AdminUser() {
		setUserName(ADMIN_USER);
		setPassword(ADMIN_PASS);
	}

	@Override
	String getName() {
		return "Admin User";
	}

	@Override
	String getUserName() {
		return ADMIN_USER;
	}

	@Override
	String getPassword() {
		return ADMIN_PASS;
	}

	@Override
	public int compareTo(User o) {
		return 0;
	}

}
