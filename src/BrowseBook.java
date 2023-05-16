import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class BrowseBook extends JFrame implements ActionListener {

	String[] cols = {"Title", "Author", "Genre" };
	String[][] bookData;
	String[] selectedBook;

	public static void main(String[] args) {
		BrowseBook at = new BrowseBook(new Member("bee", "via"));

	}

	public BrowseBook(User u) {
		bookData = BookUtils.getBookArray();

		setTitle("Browse Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);

		JPanel mainPanel = new JPanel();
		SpringLayout layout = new SpringLayout();
		mainPanel.setLayout(layout);

		JLabel mainLabel = new JLabel("All Titles");
		mainLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		layout.putConstraint(SpringLayout.WEST, mainLabel, 250, SpringLayout.WEST, mainPanel);
		layout.putConstraint(SpringLayout.NORTH, mainLabel, 25, SpringLayout.NORTH, mainPanel);

		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberPage mp = new MemberPage((Member) u);
				dispose();
			}
		});

		final JTable table = new JTable(bookData, cols);
		table.setPreferredScrollableViewportSize(new Dimension(500, 250));
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				selectedBook = bookData[row];
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 50, SpringLayout.WEST, mainPanel);
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 80, SpringLayout.NORTH, mainPanel);

		JButton checkout = new JButton("Check Out");
		layout.putConstraint(SpringLayout.EAST, checkout, -10, SpringLayout.EAST, mainPanel);
		layout.putConstraint(SpringLayout.SOUTH, checkout, -10, SpringLayout.SOUTH, mainPanel);
		JLabel newCheckoutMsg = new JLabel("Enjoy, and please be sure to return this book within 2 weeks!");
		layout.putConstraint(SpringLayout.SOUTH, newCheckoutMsg, -50, SpringLayout.SOUTH, mainPanel);
		layout.putConstraint(SpringLayout.WEST, newCheckoutMsg, 100, SpringLayout.WEST, mainPanel);

		newCheckoutMsg.setVisible(false);
		mainPanel.add(newCheckoutMsg);
		checkout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == checkout) {
					Member m = new Member(u.getUserName(), u.getPassword());
					m.checkout(selectedBook[1], selectedBook[2]);
					newCheckoutMsg.setVisible(true);
				}
			}
		});

		mainPanel.add(back);
		mainPanel.add(mainLabel);
		mainPanel.add(scrollPane);
		if (!u.getUserName().equals("ADMIN"))
			mainPanel.add(checkout);

		add(mainPanel);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
