import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminPage extends JFrame implements ActionListener {

	public static void main(String[] args) {

		AdminPage ap = new AdminPage();
	}

	public AdminPage() {
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.pink);
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.blue);
		getContentPane().add(mainPanel);

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
