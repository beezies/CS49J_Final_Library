
abstract class User implements Comparable<User> {

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

	public Member(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		setUserName(userName);
		setPassword(password);

	}

	// Quick constructor for validation
	public Member(String userName, String password) {
		setUserName(userName);
		setPassword(password);

	}

	@Override
	String getName() {
		return firstName + lastName;
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
