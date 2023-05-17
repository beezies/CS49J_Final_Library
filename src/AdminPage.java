import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.SystemColor;
import java.awt.Font;

public class AdminPage extends JFrame implements ActionListener {

	public AdminPage() {

		getContentPane().setBackground(SystemColor.info);
		SpringLayout springLayout = new SpringLayout();

		JButton btnNewButton_1_1 = new JButton("View All Titles");
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 70, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1_1, -95, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 59, SpringLayout.NORTH, getContentPane());
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseBook bbp = new BrowseBook(new AdminUser());
				dispose();
			}
		});

		JButton checkBtn = new JButton("View Users");
		checkBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, checkBtn, 70, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, checkBtn, -70, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, checkBtn, -95, SpringLayout.EAST, getContentPane());
		getContentPane().setLayout(springLayout);
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersScreen u = new UsersScreen();
			}
		});

		getContentPane().add(btnNewButton_1_1);
		getContentPane().add(checkBtn);
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(337, 250);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
