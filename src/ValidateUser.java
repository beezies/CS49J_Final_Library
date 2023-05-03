import java.util.InputMismatchException;

public class ValidateUser {

	private String userFile = "//tbd";
	private final static String ADMIN_USER = "ADMIN";
	private final static String ADMIN_PASS = "ADMIN";

	public static User validateUser(String userName, String password) throws InputMismatchException {

		if (userName.equals(ADMIN_USER) && password.equals(ADMIN_PASS)) {
			return new AdminUser();
		}
		else if (inSystem(userName, password)) {
			return new Member(userName, password);
		}
		else throw new InputMismatchException();
	}

	private static boolean inSystem(String userName, String password) {
		// check files for username password combo
		return false;
	}

}
