import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginPage {

	public static void main(String[] args) {

		LoginPage lp = new LoginPage();
		lp.makeLoginFrame();
	}

	public void makeLoginFrame() {

		JFrame frame = new JFrame("Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(275, 300);

		JPanel panel = new JPanel();
		panel.setBackground(Color.pink);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.getContentPane().add(panel);

		JLabel welcomeLabel = new JLabel("    Welcome to the Library!");
		welcomeLabel.setFont(new Font("serif", Font.PLAIN, 20));
		JLabel usrLabel = new JLabel("Enter your username:");
		JLabel passLabel = new JLabel("Enter your password:");

		JTextField usrField = new JTextField();
		usrField.setMaximumSize(new Dimension(500, usrField.getPreferredSize().height));
		JTextField passField = new JTextField();
		passField.setMaximumSize(new Dimension(500, passField.getPreferredSize().height));

		JButton loginButton = new JButton("Login");

		JLabel newUserLabel = new JLabel("<html><h1><font size =\"4\"><u>New User? Click Here!</u></font></h1></html>");

		panel.add(new JLabel("                 "));
		panel.add(welcomeLabel);
		panel.add(new JLabel("                 "));
		panel.add(usrLabel);
		panel.add(usrField);
		panel.add(passLabel);
		panel.add(passField);
		panel.add(new JLabel("                 "));
		panel.add(loginButton);
		panel.add(newUserLabel);

		loginButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Check credentials, then sign in if in file");
				System.out.println("Username: " + usrField.getText());
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});

		newUserLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Open new user page");
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});

		frame.setVisible(true);

	}

}
