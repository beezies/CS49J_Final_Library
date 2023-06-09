import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class UsersScreen extends JFrame implements HasTable {
	
	String[] cols = {"Username", "Full Name", "Books on Loan"};
	String[][] userData;

	public static void main(String[] args) {
		UsersScreen u = new UsersScreen();
	}
/*
 * displaying all current users
 */
	public UsersScreen() {
		setTitle("Viewing Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 450);

		JPanel mainPanel = new JPanel();
		SpringLayout layout = new SpringLayout();
		mainPanel.setLayout(layout);
/*
* 	creating button to display all users panel
*/		
		JLabel mainLabel = new JLabel("All Users");
		mainLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		layout.putConstraint(SpringLayout.WEST, mainLabel, 250, SpringLayout.WEST, mainPanel);
		layout.putConstraint(SpringLayout.NORTH, mainLabel, 25, SpringLayout.NORTH, mainPanel);
/*
 * button to go back to previous screen
 */
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage a = new AdminPage();
				dispose();
			}
		});		
		
		String[][] data = getData();
/*
 * displaying current users into a table		
 */		
		JTable table = new JTable(data, cols);
		table.setPreferredScrollableViewportSize(new Dimension(400, 200));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 50, SpringLayout.WEST, mainPanel);
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 90, SpringLayout.NORTH, mainPanel);

		mainPanel.add(back);
		mainPanel.add(mainLabel);
		mainPanel.add(scrollPane);
		add(mainPanel);
		setVisible(true);
	}
/*
 * getter, obtains data from members
 */
	@Override
	public String[][] getData() {
		Member[] mems = UserHandler.getSortedMembersArray();
		userData = UserHandler.makeTwoDArray(mems);
		return userData;
	}

}
