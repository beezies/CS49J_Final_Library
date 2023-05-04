import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener {

	private JPanel panel = new JPanel();
	private JLabel welcomeLabel = new JLabel("    Welcome to the Library!");
	private JLabel usrLabel = new JLabel("Enter your username:");
	private JLabel passLabel = new JLabel("Enter your password:");
	private JTextField usrField = new JTextField();
	private JTextField passField = new JTextField();
	private JButton loginButton = new JButton("Login");
	private JLabel newUserLabel = new JLabel(
			"<html><h1><font size =\"4\"><u>New User? Click Here!</u></font></h1></html>");
	private JLabel errorLabel = new JLabel(
			"<html><font size='4' color='red'> Your username or password is incorrect. </font></html>");

	public LoginPage() {

		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(275, 300);

		panel.setBackground(Color.pink);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		welcomeLabel.setFont(new Font("serif", Font.PLAIN, 20));
		usrField.setMaximumSize(new Dimension(500, usrField.getPreferredSize().height));
		passField.setMaximumSize(new Dimension(500, passField.getPreferredSize().height));
		loginButton.addActionListener(this);
		errorLabel.setBackground(Color.red);

		getContentPane().add(panel);
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

		newUserLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpPage f = new SignUpPage();
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

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginButton) {
			try {
				
				User user = ValidateUser.validateUser(usrField.getText(), passField.getText());

			} catch (InputMismatchException i) {
				
				System.out.println("die");
				panel.add(errorLabel);
				setVisible(true);
				
			}
		}
	}

	public static void main(String[] args) {

		LoginPage lp = new LoginPage();

	}

}
