import javax.swing.*;

import java.util.InputMismatchException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;

class SignUpPage extends JFrame implements ActionListener {

	public static void main(String[] args) {
		SignUpPage sup = new SignUpPage();
	}

	// Components of the Form
	private JPanel panel;
	private JLabel welcomeLabel;
	private JLabel fn;
	private JTextField fnField;
	private JLabel ln;
	private JTextField lnField;
	private JLabel user;
	private JTextField userField;
	private JLabel pass;
	private JTextField passField;
	private JLabel pass2;
	private JTextField pass2Field;
	private JButton submit;
	private JLabel endMessage;

	// constructor, to initialize the components
	// with default values.
	public SignUpPage() {
		setTitle("Sign Up");
		setBounds(300, 90, 530, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(Color.pink);
		panel.setLayout(null);
		getContentPane().add(panel);

		welcomeLabel = new JLabel("Welcome to CS49J Library!");
		welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		welcomeLabel.setSize(400, 31);
		welcomeLabel.setLocation(100, 31);
		panel.add(welcomeLabel);

		fn = new JLabel("First Name");
		fn.setFont(new Font("Arial", Font.PLAIN, 15));
		fn.setSize(100, 20);
		fn.setLocation(100, 100);
		panel.add(fn);

		fnField = new JTextField();
		fnField.setFont(new Font("Arial", Font.PLAIN, 15));
		fnField.setSize(190, 20);
		fnField.setLocation(240, 100);
		panel.add(fnField);

		ln = new JLabel("Last Name");
		ln.setFont(new Font("Arial", Font.PLAIN, 15));
		ln.setSize(100, 20);
		ln.setLocation(100, 150);
		panel.add(ln);

		lnField = new JTextField();
		lnField.setFont(new Font("Arial", Font.PLAIN, 15));
		lnField.setSize(190, 20);
		lnField.setLocation(240, 150);
		panel.add(lnField);

		user = new JLabel("Username");
		user.setFont(new Font("Arial", Font.PLAIN, 15));
		user.setSize(100, 20);
		user.setLocation(100, 200);
		panel.add(user);

		userField = new JTextField();
		userField.setFont(new Font("Arial", Font.PLAIN, 15));
		userField.setSize(190, 20);
		userField.setLocation(240, 200);
		panel.add(userField);

		pass = new JLabel("Password");
		pass.setFont(new Font("Arial", Font.PLAIN, 15));
		pass.setSize(100, 20);
		pass.setLocation(100, 250);
		panel.add(pass);

		passField = new JTextField();
		passField.setFont(new Font("Arial", Font.PLAIN, 15));
		passField.setSize(190, 20);
		passField.setLocation(240, 250);
		panel.add(passField);

		pass2 = new JLabel("Confirm password");
		pass2.setFont(new Font("Arial", Font.PLAIN, 15));
		pass2.setSize(200, 20);
		pass2.setLocation(100, 300);
		panel.add(pass2);

		pass2Field = new JTextField();
		pass2Field.setFont(new Font("Arial", Font.PLAIN, 15));
		pass2Field.setSize(190, 20);
		pass2Field.setLocation(240, 300);
		panel.add(pass2Field);

		submit = new JButton("Submit");
		submit.setFont(new Font("Arial", Font.PLAIN, 15));
		submit.setSize(100, 40);
		submit.setLocation(200, 350);
		submit.addActionListener(this);
		panel.add(submit);

		endMessage = new JLabel("");
		endMessage.setFont(new Font("Arial", Font.PLAIN, 20));
		endMessage.setSize(500, 25);
		endMessage.setLocation(150, 410);
		panel.add(endMessage);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			if (fnField.getText().isBlank() || lnField.getText().isBlank() || userField.getText().isBlank()
					|| passField.getText().isBlank() || pass2Field.getText().isBlank()) {
				endMessage.setText("Please fill all fields.");
			} else if (!passField.getText().equals(pass2Field.getText())) {
				endMessage.setText("Passwords must match.");
			} else {
				try {
					Member m = new Member(userField.getText(), passField.getText(), fnField.getText(),
							lnField.getText());

					endMessage.setText("Registered Successfully!");

					Timer timer = new Timer();
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							MemberPage mp = new MemberPage(new Member(userField.getText(), pass.getText()));
							dispose();
						}
					};
					timer.schedule(task, (long) 1000);

				} catch (InputMismatchException i) {
					endMessage.setText("Username already in use.");
				}

			}

		}
	}

}
