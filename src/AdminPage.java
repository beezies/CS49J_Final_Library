import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.SystemColor;
import java.awt.Font;


public class AdminPage extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		AdminPage mp = new AdminPage();
	}
	
	public AdminPage() {
		
		getContentPane().setBackground(SystemColor.info);
		
		JButton checkBtn = new JButton("View Users");
		checkBtn.setVerticalAlignment(SwingConstants.TOP);
		checkBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckedOut cop = new CheckedOut();
				dispose();
			}
		});
		
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, checkBtn, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, checkBtn, -170, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, checkBtn, -95, SpringLayout.EAST, getContentPane());
		getContentPane().setLayout(springLayout);
		getContentPane().add(checkBtn);
		
		JButton odBtn = new JButton("All Overdue Books");
		springLayout.putConstraint(SpringLayout.NORTH, odBtn, 48, SpringLayout.SOUTH, checkBtn);
		springLayout.putConstraint(SpringLayout.WEST, odBtn, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, odBtn, -95, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, odBtn, 0, SpringLayout.EAST, checkBtn);
		odBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOverdueADM op = new ViewOverdueADM();
				dispose();
			}
		});
		odBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(odBtn);
		
		JButton btnNewButton_1_1 = new JButton("View All Titles");
		springLayout.putConstraint(SpringLayout.NORTH, checkBtn, 46, SpringLayout.SOUTH, btnNewButton_1_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 87, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1_1, -95, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 59, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -243, SpringLayout.SOUTH, getContentPane());
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseBook bbp = new BrowseBook(new AdminUser());
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_1_1);
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(337, 368);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
