import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class regFrame
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField textName;
    private JLabel user;
    private JTextField textUser;
    private JLabel pass;
    private JTextField textPass;
    private JLabel re;
    private JLabel pass2;
    private JTextField textPass2;
    private JLabel add;
    private JTextArea textAdd;
    private JCheckBox term;
    private JButton submit;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea repeat;

    // constructor, to initialize the components
    // with default values.
    public regFrame()
    {
        setTitle("Sign Up");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Sign Up");
        title.setFont(new Font("Arial", Font.PLAIN, 28));
        title.setSize(300, 31);
        title.setLocation(300, 31);
        c.add(title);

        name = new JLabel("Full Name");
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        textName = new JTextField();
        textName.setFont(new Font("Arial", Font.PLAIN, 15));
        textName.setSize(190, 20);
        textName.setLocation(240, 100);
        c.add(textName);

        user = new JLabel("Username");
        user.setFont(new Font("Arial", Font.PLAIN, 15));
        user.setSize(100, 20);
        user.setLocation(100, 150);
        c.add(user);

        textUser = new JTextField();
        textUser.setFont(new Font("Arial", Font.PLAIN, 15));
        textUser.setSize(190, 20);
        textUser.setLocation(240, 150);
        c.add(textUser);

        pass = new JLabel("Password");
        pass.setFont(new Font("Arial", Font.PLAIN, 15));
        pass.setSize(100, 20);
        pass.setLocation(100, 200);
        c.add(pass);

        textPass = new JTextField();
        textPass.setFont(new Font("Arial", Font.PLAIN, 15));
        textPass.setSize(190, 20);
        textPass.setLocation(240, 200);
        c.add(textPass);

        re = new JLabel("Re-type");
        re.setFont(new Font("Arial", Font.PLAIN, 15));
        re.setSize(100, 20);
        re.setLocation(100, 250);
        c.add(re);

        pass2 = new JLabel("Password");
        pass2.setFont(new Font("Arial", Font.PLAIN, 15));
        pass2.setSize(100, 20);
        pass2.setLocation(158, 250);
        c.add(pass2);

        textPass2 = new JTextField();
        textPass2.setFont(new Font("Arial", Font.PLAIN, 15));
        textPass2.setSize(190, 20);
        textPass2.setLocation(240, 250);
        c.add(textPass2);

        add = new JLabel("Email Address");
        add.setFont(new Font("Arial", Font.PLAIN, 15));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        textAdd = new JTextArea();
        textAdd.setFont(new Font("Arial", Font.PLAIN, 15));
        textAdd.setSize(190, 20);
        textAdd.setLocation(240, 300);
        textAdd.setLineWrap(true);
        c.add(textAdd);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 350);
        c.add(term);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(100, 20);
        submit.setLocation(150, 400);
        submit.addActionListener(this);
        c.add(submit);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 400);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 200);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        repeat = new JTextArea();
        repeat.setFont(new Font("Arial", Font.PLAIN, 15));
        repeat.setSize(200, 75);
        repeat.setLocation(580, 175);
        repeat.setLineWrap(true);
        c.add(repeat);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit) {
            if (term.isSelected()) {
                String data
                        = "Name : "
                        + textName.getText() + "\n"
                        + "Username : "
                        + textUser.getText() + "\n"
                        + "Password : "
                        + textPass.getText() + "\n";

                String data1 = "Email Address : " + textAdd.getText();
                tout.setText(data + data1);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
            }
            else {
                tout.setText("");
                repeat.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            textName.setText(def);
            textAdd.setText(def);
            textUser.setText(def);
            textPass.setText(def);
            textPass2.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            repeat.setText(def);
        }
    }
}
