import java.awt.Desktop;
import java.io.File;

abstract class User implements Comparable<User>, CanOpenFile {

	public static void main(String[] args) {
//		Member n = new Member("bee", "via", "bri", "rog");
		Member n = new Member("bee", "via");
		n.returnBook("h", "h");
		n.returnBook("L", "l");

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

	@Override
	public void openBook(String pdfName) {
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File(pdfName + ".pdf");
				Desktop.getDesktop().open(myFile);
			} catch (Exception ex) {
			}
		}
	}
}

interface CanOpenFile {

	public void openBook(String pdfName);

}
