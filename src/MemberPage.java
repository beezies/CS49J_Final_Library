import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.SystemColor;
import java.awt.Font;

public class MemberPage extends JFrame implements ActionListener {

	public MemberPage(Member m) {

		getContentPane().setBackground(SystemColor.info);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JButton btnNewButton_1_1 = new JButton("Browse Books");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1_1, -95, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 59, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -243, SpringLayout.SOUTH, getContentPane());
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseBook b = new BrowseBook(m);
				dispose();
			}
		});
		getContentPane().add(btnNewButton_1_1);

		JButton checkBtn = new JButton("Checked Out");
		springLayout.putConstraint(SpringLayout.NORTH, checkBtn, 46, SpringLayout.SOUTH, btnNewButton_1_1);
		springLayout.putConstraint(SpringLayout.WEST, checkBtn, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, checkBtn, -160, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, checkBtn, -95, SpringLayout.EAST, getContentPane());
		checkBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckedOut c = new CheckedOut(m);
				dispose();
			}
		});
		getContentPane().add(checkBtn);

		JButton rando = new JButton("WildCard Checkout");
		springLayout.putConstraint(SpringLayout.NORTH, rando, 46, SpringLayout.SOUTH, checkBtn);
		springLayout.putConstraint(SpringLayout.WEST, rando, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, rando, -95, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, rando, -70, SpringLayout.SOUTH, getContentPane());
		rando.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel randoMessage = new JLabel(
				"<html><font size='4' color='red'>A new book has been checked out for you! </font></html>");
		randoMessage.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, randoMessage, 20, SpringLayout.SOUTH, rando);
		springLayout.putConstraint(SpringLayout.WEST, randoMessage, 20, SpringLayout.WEST, getContentPane());
		rando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookUtils.randomCheckout(m);
				randoMessage.setVisible(true);
			}
		});
		getContentPane().add(rando);
		getContentPane().add(randoMessage);

		setTitle("Member Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(337, 368);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
