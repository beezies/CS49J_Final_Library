import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MemberPage extends JFrame implements ActionListener{
	
	public MemberPage(Member m) {
		setTitle("Member Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(275, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
