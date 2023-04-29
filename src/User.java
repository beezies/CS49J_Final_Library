
abstract class User {

	private String userName;
	private String password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	abstract String getName();

}

class Member extends User {

	private String firstName;
	private String lastName;

	public Member(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		setUserName(userName);
		setPassword(password);

	}

	@Override
	String getName() {
		return firstName + lastName;
	}

}

class AdminUser extends User {

	private final String userName = "ADMIN";
	private final String password = "ADMIN";

	public AdminUser() {
		setUserName(userName);
		setPassword(password);
	}

	@Override
	String getName() {
		return "Admin User";
	}

}
