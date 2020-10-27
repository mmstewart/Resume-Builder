import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.awt.*;

public class SignUp extends JFrame implements ActionListener{
    public JLabel l,l1,l2,l3,l6;
    public JTextField t1;
    public JRadioButton b1,b2,b3;
    public ButtonGroup bg=new ButtonGroup();
    public JPasswordField t2,t3;
    public JButton b4;
    public Font f;

    public SignUp() {
        f = new Font("SansSerif", Font.BOLD, 20);
        l = new JLabel("Sign Up");
        l.setFont(f);
        l1=new JLabel("Username:");
        l2=new JLabel("Password:");
        l3=new JLabel("Confirm Password:");
        t1=new JTextField();
        t2=new JPasswordField();
        t3=new JPasswordField();
        b4=new JButton("Sign Up");
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        l.setBounds(150, 10, 100, 100);
        l1.setBounds(50,100,100,40);
        l2.setBounds(50,140,100,40);
        l3.setBounds(50,180,200,40);
        t1.setBounds(200,100,200,40);
        t2.setBounds(200,140,200,40);
        t3.setBounds(200,180,200,40);
        b4.setBounds(160,380,100,50);
        b4.addActionListener(this);
        add(b4);
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
        setLayout(null);
        setSize(500,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

    }
}
