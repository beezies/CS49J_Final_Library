import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

public class CheckedOut extends JFrame implements ActionListener {

	public static void main(String[] args) {
		CheckedOut co = new CheckedOut(new Member("bee", "via"));
	}

	String[] cols = { "Title", "Author", "Checkout Date" };
	String[][] bookData;
	String[] selectedBook;

	public CheckedOut(Member m) {
		setTitle("Checked Out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);

		JButton btnNewButton = new JButton("Back");
		layout.putConstraint(SpringLayout.EAST, btnNewButton, 65, SpringLayout.WEST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberPage mp = new MemberPage(m);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		layout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Your Currently Loaned Books");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel, 30, SpringLayout.EAST, btnNewButton);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		bookData = BookUtils.getMembersBooks(m);

		final JTable table = new JTable(bookData, cols);
		table.setPreferredScrollableViewportSize(new Dimension(300, 200));
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				selectedBook = bookData[row];
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 80, SpringLayout.NORTH, contentPane);
		contentPane.add(scrollPane);

		JButton btnNewButton_1 = new JButton("Return Book");
		JLabel newReturnMsg = new JLabel("Returned Successfully!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_1) {
					m.returnBook(selectedBook[1], selectedBook[2]);
					contentPane.add(newReturnMsg);
				}
			}
		});
		layout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_1);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
