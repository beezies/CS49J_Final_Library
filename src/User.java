import java.awt.Desktop;
import java.io.File;

abstract class User implements Comparable<User>, CanOpenFile {
/**
* Quick constructor for users
* 
* @param userName
* @param password
*/
	protected String userName;
	protected String password;
/*
 * setter for user name
 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
/*
* setter for password
*/
	public void setPassword(String password) {
		this.password = password;
	}

	abstract String getName();

	abstract String getUserName();

	abstract String getPassword();
/*
 * saves information into file
 */
	@Override
	public void openFile(String fileName) {
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File(fileName);
				Desktop.getDesktop().open(myFile);
			} catch (Exception ex) {
			}
		}
	}
}

interface CanOpenFile {

	public void openFile(String pdfName);

}
/*
 * admin login and password information
 */
class AdminUser extends User {

	private final String ADMIN_USER = "ADMIN";
	private final String ADMIN_PASS = "ADMIN";

	public AdminUser() {
		setUserName(ADMIN_USER);
		setPassword(ADMIN_PASS);
	}
/*
 * getters for admin name
 */
	@Override
	String getName() {
		return "Admin User";
	}
/*
* getters for admin user name
*/
	@Override
	String getUserName() {
		return ADMIN_USER;
	}
/*
 * setters for admin password
 */
	@Override
	String getPassword() {
		return ADMIN_PASS;
	}
/*
 * compares if information input is the same as the one stored
 */
	@Override
	public int compareTo(User o) {
		return 0;
	}

}
