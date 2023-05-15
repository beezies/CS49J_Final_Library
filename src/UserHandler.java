import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserHandler {

	private static String userFile = "Members.json";
	private final static String ADMIN_USER = "ADMIN";
	private final static String ADMIN_PASS = "ADMIN";
	private static JSONObject membersJSON;
	private static JSONArray membersArrayJSON;

	public static User validateUser(String userName, String password) throws IllegalArgumentException {

		if (userName.equals(ADMIN_USER) && password.equals(ADMIN_PASS)) {
			return new AdminUser();
		} else if (inSystem(userName, password)) {
			return new Member(userName, password);
		} else
			throw new IllegalArgumentException();
	}

	private static boolean inSystem(String userName, String password) {
		boolean valid = false;
		membersArrayJSON = getMembersArrayJSON();

		for (int i = 0; i < membersArrayJSON.length(); i++) {
			JSONObject member = membersArrayJSON.getJSONObject(i);
			String uname = member.getString("username");
			String pass = member.getString("password");
			if (uname.equalsIgnoreCase(userName) && pass.equals(password)) {
				valid = true;
				break;
			}
		}
		return valid;
	}

	public static JSONArray getMembersArrayJSON() {
		getMembersJSON();

		membersArrayJSON = membersJSON.getJSONArray("members");
		return membersArrayJSON;
	}
	
	private static JSONObject getMembersJSON() {
		try {

			InputStream is;
			is = new FileInputStream(getFileName());
			String memberFileText = IOUtils.toString(is, "UTF-8");
			membersJSON = new JSONObject(memberFileText);
			return membersJSON;

		} catch (Exception e) {
		}
		return null;
	}

	public static void updateUserFile(JSONArray members) throws IOException {
		new FileOutputStream(getFileName()).close();
		
		membersArrayJSON = members;
		membersJSON.remove("members");
		membersJSON.put("members", membersArrayJSON);
		System.out.println(membersJSON);
		
		Files.write(getFilePath(), membersJSON.toString().getBytes(), StandardOpenOption.WRITE);
	}

	public static Path getFilePath() {
		return Paths.get(userFile);
	}

	public static String getFileName() {
		return userFile;
	}

}
