import java.io.DataInputStream;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class BookUtils {
/*
 * Creating a book list and storing books into file
 and display
 */
	public static String[][] getBookArray() {
		String fName = "BookList.csv";
		String line;
		FileInputStream fis;
		try {
			fis = new FileInputStream(fName);
			DataInputStream input = new DataInputStream(fis);
			LinkedList<String[]> lines = new LinkedList<String[]>();
			while ((line = input.readLine()) != null) {
				lines.add(line.split(","));
			}

			String[][] array = new String[lines.size()][3];
			lines.toArray(array);
			return array;
		} catch (Exception e) {
		}
		return null;
	}
	
/*
 * Gets members books and displays checkout date and whether it is overdue
 */
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
				arr[i][2] = book.getString("checkout date") + "[OVERDUE]";
		}
		return arr;
	}
/*
 * method that pulls a random book from the pile and checkouts  
 */
	public static void randomCheckout(Member m) {
		String[][] books = getBookArray();
		int upper = books.length;
		Random rand = new Random();
		int randIdx = rand.nextInt(upper);
		
		String[] book = books[randIdx];
		
		m.checkout(book[0], book[1]);
	}

}
