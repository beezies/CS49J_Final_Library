
abstract class User {

	private String userName;
	private String password;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}

class Member extends User {

	public Member(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		
	}

}

class AdminUser extends User {
	
	private final String userName = "ADMIN";
	private final String password = "ADMIN";

	public AdminUser() {
		setUserName(userName);
		setPassword(password);
	}
	
}
