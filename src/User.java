
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import org.json.JSONObject;
import org.json.JSONArray;
import org.apache.commons.io.IOUtils;

abstract class User implements Comparable<User> {

	public static void main(String[] args) {
		Member m = new Member("ehh", "evv", "ebb", "ell");
//		m.checkout("book", "collins");
//		m.checkout("book", "collins");
//		m.checkout("book", "collins");

	}

	public static final String memberFileName = "Members.json";
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

}

class Member extends User {

	private String firstName;
	private String lastName;
	JSONObject memberJSON;
	JSONArray books;

	// New account
	public Member(String firstName, String lastName, String userName, String password) {
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

	private void addToFile() {

		try {
			InputStream is = new FileInputStream(memberFileName);
			String memberFileText = IOUtils.toString(is, "UTF-8");
			JSONObject membersJSON = new JSONObject(memberFileText);
			JSONArray membersArray = membersJSON.getJSONArray("members");
			System.out.println(membersJSON);

			memberJSON.put("username", userName);
			memberJSON.put("password", password);
			memberJSON.put("first name", firstName);
			memberJSON.put("last name", lastName);
			memberJSON.put("books checked", books);

			membersArray.put(memberJSON);
			System.out.println(membersJSON);


			Files.write(getFilePath(), membersJSON.toString().getBytes(), StandardOpenOption.WRITE);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private Path getFilePath() {

		return Paths.get(memberFileName);
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

	public void checkout(String title, String author) {
		JSONObject book = new JSONObject();
		book.put("title", title);
		book.put("author", author);
		book.put("checkout date", LocalDate.now().toString());

		books.put(book);

		System.out.println(memberJSON);
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
