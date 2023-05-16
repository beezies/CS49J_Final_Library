import java.io.DataInputStream;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class BookUtils {

	public static void main(String[] args) {
		getBookArray();
	}

	public static String[][] getBookArray() {
		String fName = "BookList.csv";
		String line;
		FileInputStream fis;
		try {
			fis = new FileInputStream(fName);
			DataInputStream input = new DataInputStream(fis);
			ArrayList<String[]> lines = new ArrayList<String[]>();
			while ((line = input.readLine()) != null) {
				lines.add(line.split(","));
			}

			String[][] array = new String[lines.size()][3];
			lines.toArray(array);

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.println(array[i][j]);
				}
			}
			return array;
		} catch (Exception e) {
		}
		return null;
	}

	public static String[][] getMembersBooks(Member m) {
		JSONArray booksJSON = m.getBooks();
		String[][] arr = new String[booksJSON.length()][3];
		for (int i = 0; i < booksJSON.length(); i++) {
			JSONObject book = booksJSON.getJSONObject(i);
			arr[i][0] = book.getString("title");
			arr[i][1] = book.getString("author");
			if ((LocalDate.now().toString()).equals(book.getString("checkout date")))
				arr[i][2] = book.getString("checkout date");
			else
				arr[i][2] = "OVERDUE";
		}
		return arr;
	}

}
