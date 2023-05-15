
import java.io.IOException;
import java.time.LocalDate;

import org.json.JSONObject;
import org.json.JSONArray;

public class Member extends User {

	public static void main(String[] args) {
//		Member d = new Member("geek", "nerd", "dima", "smyr");
//		Member b = new Member("bee", "via", "bri", "rog");
		Member bee = new Member("bee", "via");
		bee.checkout("willow", "hunter");
	}

	private String firstName;
	private String lastName;
	JSONObject memberJSON;
	JSONArray booksJSON;

	/**
	 * New user
	 * 
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @throws IllegalArgumentException
	 */
	public Member(String userName, String password, String firstName, String lastName) throws IllegalArgumentException {
		this.firstName = firstName;
		this.lastName = lastName;
		setUserName(userName);
		setPassword(password);

		addToFile();
	}

	/**
	 * Quick constructor for login
	 * 
	 * @param userName
	 * @param password
	 */
	public Member(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		setMemberJSON();
	}

	/**
	 * Creates JSON object for user and adds newly constructed user to JSON file
	 * 
	 * @throws IllegalArgumentException
	 */
	private void addToFile() throws IllegalArgumentException {

		JSONArray membersArray = UserHandler.getMembersJSONArray();
		memberJSON = new JSONObject();
		booksJSON = new JSONArray();

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

		try {
			UserHandler.updateUserFile(membersArray);
		} catch (Exception e) {
		}

	}

	/**
	 * Instantiates JSON objects for user from users file
	 */
	private void setMemberJSON() {

		JSONArray membersArray = UserHandler.getMembersJSONArray();

		for (int i = 0; i < membersArray.length(); i++) {

			JSONObject mem = membersArray.getJSONObject(i);
			String uname = mem.getString("username");
			if (uname.equals(userName)) {
				memberJSON = mem;
				booksJSON = memberJSON.getJSONArray("books checked");
			}
		}

		System.out.println(memberJSON);
	}

	public void checkout(String title, String author) {
		JSONObject book = new JSONObject();
		book.put("title", title);
		book.put("author", author);
		book.put("checkout date", LocalDate.now().toString());
		System.out.println("book to check: " + book);

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

	/**
	 * Uses a switch to perform the desired action on a given book.
	 * @param book
	 * @param action
	 */
	public void handleBook(JSONObject book, String action) {

		JSONArray membersArray = UserHandler.getMembersJSONArray();

		for (int i = 0; i < membersArray.length(); i++) {

			JSONObject mem = membersArray.getJSONObject(i);
			System.out.println("User " + i + ":" + mem);
			String uname = mem.getString("username");
			if (uname.equals(userName)) {
				memberJSON = mem;
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
		try {
			UserHandler.updateUserFile(membersArray);
		} catch (IOException e) {
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
