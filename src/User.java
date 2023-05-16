import java.awt.Desktop;
import java.io.File;

abstract class User implements Comparable<User>, CanOpenFile {

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
