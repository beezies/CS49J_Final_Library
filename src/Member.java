
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import org.json.JSONObject;
import org.json.JSONArray;
import org.apache.commons.io.IOUtils;

public class Member extends User {

	private String firstName;
	private String lastName;
	JSONObject memberJSON;
	JSONArray booksJSON;

	// New account
	public Member(String userName, String password, String firstName, String lastName) throws IllegalArgumentException {
		this.firstName = firstName;
		this.lastName = lastName;
		setUserName(userName);
		setPassword(password);

		addToFile();
	}

	// Quick constructor for login
	public Member(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		getMemberJSON();
	}

	private void addToFile() throws IllegalArgumentException {

		memberJSON = new JSONObject();
		booksJSON = new JSONArray();

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
			memberJSON.put("books checked", booksJSON);

			membersArray.put(memberJSON);

			Files.write(UserHandler.getFilePath(), membersJSON.toString().getBytes(), StandardOpenOption.WRITE);
		} catch (Exception e1) {
			throw new IllegalArgumentException();
		}
	}

	private void getMemberJSON() {
		try {
			InputStream is = new FileInputStream(UserHandler.getFileName());
			String memberFileText = IOUtils.toString(is, "UTF-8");
			JSONObject membersJSON = new JSONObject(memberFileText);
			JSONArray membersArray = membersJSON.getJSONArray("members");

			for (int i = 0; i < membersArray.length(); i++) {

				JSONObject mem = membersArray.getJSONObject(i);
				String uname = mem.getString("username");
				if (uname.equals(userName)) {
					memberJSON = mem;
					booksJSON = memberJSON.getJSONArray("books checked");
				}
			}

			System.out.println(membersJSON);
		} catch (Exception e1) {
		}

	}

	public void checkout(String title, String author) {
		JSONObject book = new JSONObject();
		book.put("title", title);
		book.put("author", author);
		book.put("checkout date", LocalDate.now().toString());

		handleBook(book, "checkout");
	}

	public void readBook(String title, String author) {
		JSONObject book = new JSONObject();
		book.put("title", title);
		book.put("author", author);
		book.put("checkout date", LocalDate.now().toString());

		handleBook(book, "open");
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
			System.out.println(memberFileText);
			JSONObject membersJSON = new JSONObject(memberFileText);
			JSONArray membersArray = membersJSON.getJSONArray("members");

			for (int i = 0; i < membersArray.length(); i++) {

				memberJSON = membersArray.getJSONObject(i);
				String uname = memberJSON.getString("username");
				if (uname.equals(userName)) {
					booksJSON = memberJSON.getJSONArray("books checked");

					switch (action) {
					case "checkout":
						booksJSON.put(book);
						break;
					case "return":
						if (hasBook(book) >= 0)
							booksJSON.remove(hasBook(book));
						break;
					case "open":
						if (hasBook(book) >= 0)
							openBook(book.getString("title") + book.getString("author"));
					}
				}
			}
			Files.write(UserHandler.getFilePath(), membersJSON.toString().getBytes(), StandardOpenOption.WRITE);
		} catch (Exception e1) {
		}
	}

	private int hasBook(JSONObject book) {
		for (int j = 0; j < booksJSON.length(); j++) {
			JSONObject bookJSON = booksJSON.getJSONObject(j);
			String title = bookJSON.getString("title");
			String author = bookJSON.getString("author");
			if (title.equals(book.getString("title")) && author.equals(book.getString("author"))) {
				return j;
			}
		}
		return -1;
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


