import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.SystemColor;
import java.awt.Font;


public class MemberPage extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		MemberPage mp = new MemberPage(new Member("bee", "via"));
	}
	
	public MemberPage(Member m) {
		
		getContentPane().setBackground(SystemColor.info);
		
		JButton checkBtn = new JButton("Checked Out");
		checkBtn.setVerticalAlignment(SwingConstants.TOP);
		checkBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckedOut c = new CheckedOut(m);
				dispose();
			}
		});
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, checkBtn, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, checkBtn, -170, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, checkBtn, -95, SpringLayout.EAST, getContentPane());
		getContentPane().setLayout(springLayout);
		getContentPane().add(checkBtn);
		
		JButton btnNewButton_1_1 = new JButton("Browse Books");
		springLayout.putConstraint(SpringLayout.NORTH, checkBtn, 46, SpringLayout.SOUTH, btnNewButton_1_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1_1, -95, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 59, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -243, SpringLayout.SOUTH, getContentPane());
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseBook b = new BrowseBook(m);
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
