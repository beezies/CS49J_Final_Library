import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

public class CheckedOut extends JFrame implements HasTable {

	String[] cols = { "Title", "Author", "Checkout Date" };
	String[][] bookData;
	String[] selectedBook;
	Member m;

	public CheckedOut(Member m) {
		this.m = m;
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

		String[][] data = getData();

		final JTable table = new JTable(data, cols);
		table.setPreferredScrollableViewportSize(new Dimension(350, 200));
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				selectedBook = data[row];
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 80, SpringLayout.NORTH, contentPane);
		contentPane.add(scrollPane);

		JButton btnNewButton_1 = new JButton("Return Book");
		JLabel newReturnMsg = new JLabel("Returned Successfully!");
		newReturnMsg.setVisible(false);
		layout.putConstraint(SpringLayout.SOUTH, newReturnMsg, -15, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, newReturnMsg, -200, SpringLayout.EAST, contentPane);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_1) {
					m.returnBook(selectedBook[0], selectedBook[1]);
					newReturnMsg.setVisible(true);
				}
			}
		});
		
		contentPane.add(newReturnMsg);


		JButton openButton = new JButton("Open Book");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == openButton) {
					m.readBook(selectedBook[0], selectedBook[1]);
				}
			}
		});
		layout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.WEST, openButton, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, openButton, -10, SpringLayout.SOUTH, contentPane);

		contentPane.add(btnNewButton_1);
		contentPane.add(openButton);

		setVisible(true);

	}

	@Override
	public String[][] getData() {
		return  BookUtils.getMembersBooks(m);
	}

}
