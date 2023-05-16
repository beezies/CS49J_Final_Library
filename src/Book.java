import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Book {

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

}
