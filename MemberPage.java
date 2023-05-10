package library;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.SystemColor;
import java.awt.Font;


public class MemberPage extends JFrame implements ActionListener{
	
	public MemberPage(Member m) {
		getContentPane().setBackground(SystemColor.info);
		
		JButton btnNewButton = new JButton("Checked Out");
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkedOut cop = new checkedOut();
				dispose();
			}
		});
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -170, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -95, SpringLayout.EAST, getContentPane());
		getContentPane().setLayout(springLayout);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Overdue");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 48, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -95, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				overdue op = new overdue();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Browse Books");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 46, SpringLayout.SOUTH, btnNewButton_1_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1_1, -95, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 59, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -243, SpringLayout.SOUTH, getContentPane());
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browseBook bbp = new browseBook();
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_1_1);
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