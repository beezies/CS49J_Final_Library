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
    private JLabel numb;
    private JTextField textNum;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup genderButton;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea textAdd;
    private JCheckBox term;
    private JButton submit;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea repeat;

    private String months[]
            = { "Jan", "Feb", "Mar", "Apr",
            "May", "June", "July", "Aug",
            "Sept", "Oct", "Nov", "Dec" };

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String years[]
            = { "1990", "1991", "1992", "1993", "1994",
            "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021", "2022" };

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

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        textName = new JTextField();
        textName.setFont(new Font("Arial", Font.PLAIN, 15));
        textName.setSize(190, 20);
        textName.setLocation(200, 100);
        c.add(textName);

        numb = new JLabel("Phone Number");
        numb.setFont(new Font("Arial", Font.PLAIN, 15));
        numb.setSize(100, 20);
        numb.setLocation(100, 150);
        c.add(numb);

        textNum = new JTextField();
        textNum.setFont(new Font("Arial", Font.PLAIN, 15));
        textNum.setSize(150, 20);
        textNum.setLocation(200, 150);
        c.add(textNum);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 15));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);

        genderButton = new ButtonGroup();
        genderButton.add(male);
        genderButton.add(female);

        dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial", Font.PLAIN, 15));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(200, 250);
        c.add(month);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(260, 250);
        c.add(date);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 250);
        c.add(year);

        add = new JLabel("Email Address");
        add.setFont(new Font("Arial", Font.PLAIN, 15));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        textAdd = new JTextArea();
        textAdd.setFont(new Font("Arial", Font.PLAIN, 15));
        textAdd.setSize(200, 20);
        textAdd.setLocation(200, 300);
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
                String data1;
                String data
                        = "Name : "
                        + textName.getText() + "\n"
                        + "Phone Number : "
                        + textNum.getText() + "\n";
                if (male.isSelected())
                    data1 = "Gender : Male"
                            + "\n";
                else
                    data1 = "Gender : Female"
                            + "\n";
                String data2
                        = "Date of Birth : "
                        + (String)month.getSelectedItem()
                        + "/" + (String)date.getSelectedItem()
                        + "/" + (String)year.getSelectedItem()
                        + "\n";

                String data3 = "Email Address : " + textAdd.getText();
                tout.setText(data + data1 + data2 + data3);
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
            textNum.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            repeat.setText(def);
        }
    }
}

class Registration {

    public static void main(String[] args) throws Exception
    {
        regFrame f = new regFrame();
    }
}