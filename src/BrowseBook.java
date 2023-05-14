
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.Font;

public class BrowseBook extends JFrame implements ActionListener{

	public BrowseBook(boolean admin) {
		setTitle("Browse Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(333, 378);
		setVisible(true);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Arial", Font.PLAIN, 11));
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member user = null;
				MemberPage mp = new MemberPage(user);
				dispose();
			}
		});
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, backButton, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, backButton, 0, SpringLayout.WEST, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(backButton);
		
		JLabel lblNewLabel = new JLabel("Browse Books");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 48, SpringLayout.EAST, backButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 33, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -80, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel newcheckoutMsg = new JLabel("<html>Enjoy! this book will be due on<br/>MM/DD/YYYY</html>");
		newcheckoutMsg.setVisible(false);
		
		JButton btnNewButton = new JButton("Checkout");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) 
						newcheckoutMsg.setVisible(true);
			
		}});
		
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, contentPane);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnNewButton);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, newcheckoutMsg, -18, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, newcheckoutMsg, 0, SpringLayout.WEST, backButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, newcheckoutMsg, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, newcheckoutMsg, -16, SpringLayout.WEST, btnNewButton);
		newcheckoutMsg.setFont(new Font("Arial", Font.PLAIN, 15));
		newcheckoutMsg.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(newcheckoutMsg);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
