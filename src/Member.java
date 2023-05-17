
import java.io.IOException;
import java.time.LocalDate;

import org.json.JSONObject;
import org.json.JSONArray;

public class Member extends User {

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

		JSONArray membersArray = UserHandler.getMembersArrayJSON();
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

		JSONArray membersArray = UserHandler.getMembersArrayJSON();

		for (int i = 0; i < membersArray.length(); i++) {

			JSONObject mem = membersArray.getJSONObject(i);
			String uname = mem.getString("username");
			if (uname.equals(userName)) {
				memberJSON = mem;
				booksJSON = memberJSON.getJSONArray("books checked");
				firstName = memberJSON.getString("first name");
				lastName = memberJSON.getString("last name");
			}
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

	/**
	 * Uses a switch to perform the desired action on a given book.
	 * 
	 * @param book
	 * @param action
	 */
	public void handleBook(JSONObject book, String action) {

		JSONArray membersArray = UserHandler.getMembersArrayJSON();

		for (int i = 0; i < membersArray.length(); i++) {

			JSONObject mem = membersArray.getJSONObject(i);
			String uname = mem.getString("username");
			if (uname.equals(userName)) {
				memberJSON = mem;
				booksJSON = memberJSON.getJSONArray("books checked");

				switch (action) {
				case "checkout":
					booksJSON.put(book);
					break;
				case "return":
					int idx = hasBook(book);
					if (idx >= 0)
						booksJSON.remove(idx);
					break;
				case "open":
					if (hasBook(book) >= 0)
						openFile(book.getString("title") + book.getString("author") + ".pdf");
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

	public JSONArray getBooks() {
		return booksJSON;
	}

	@Override
	String getName() {
		return firstName + " " + lastName;
	}

	@Override
	String getUserName() {
		setMemberJSON();
		return userName;
	}

	@Override
	String getPassword() {
		setMemberJSON();
		return password;
	}

	@Override
	public int compareTo(User o) {

		if (o == this)
			return 0;

		int userNameDiff = (o.getUserName().compareTo(this.getUserName()));
		if (userNameDiff < 0) {
			return 1;
		} else if (userNameDiff < 0)
			return -1;

		return 0;
	}

	public String toString() {
		setMemberJSON();
		return memberJSON.toString();

	}
}
