import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener {
/**
* Quick constructor for login
* 
* @param userName
* @param password
*/
	private JPanel panel = new JPanel();
	private JLabel libLabel = new JLabel("             ~ CS49J Library ~");
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
/*
 * displaying login page
 */
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(275, 300);

		panel.setBackground(Color.pink);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		libLabel.setFont(new Font("serif", Font.PLAIN, 20));
		usrField.setMaximumSize(new Dimension(500, usrField.getPreferredSize().height));
		passField.setMaximumSize(new Dimension(500, passField.getPreferredSize().height));
		loginButton.addActionListener(this);

		getContentPane().add(panel);
		panel.add(new JLabel("                 "));
		panel.add(libLabel);
		panel.add(new JLabel("                 "));
		panel.add(usrLabel);
		panel.add(usrField);
		panel.add(passLabel);
		panel.add(passField);
		panel.add(new JLabel("                 "));
		panel.add(loginButton);
		panel.add(newUserLabel);

		newUserLabel.addMouseListener(new MouseListener() {
/*
 * button to redirect users to sign up page if they are currently not members
 */
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpPage f = new SignUpPage();
				dispose();
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
/*
 * button to login once signed up/current and existing users can be redirected to member screen while admins are redirected to aadmin page
 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginButton) {
			try {

				User user = UserHandler.validateUser(usrField.getText(), passField.getText());
				dispose();

				if (user.getName().equals("Admin User")) {
					AdminPage ap = new AdminPage();
				} else {
					Member m = (Member) user;
					MemberPage mp = new MemberPage(m);
				}

			} catch (IllegalArgumentException i) {

				panel.add(errorLabel);
				setVisible(true);

			}
		}
	}

	public static void main(String[] args) {

		LoginPage lp = new LoginPage();

	}

}
