 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame implements ActionListener {
    public JLabel rb;
    public JButton b1, b2;
    public Font f;

    public LandingPage() {
        f = new Font("SansSerif", Font.BOLD, 38);
        rb = new JLabel("Resume Builder");
        rb.setFont(f);
        b1=new JButton("Login");
        b2=new JButton("Sign Up");
        rb.setBounds(30, 50, 400, 100);
        b1.setBounds(80,160,100,50);
        b2.setBounds(200,160,100,50);
        add(rb);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(null);
        setSize(400,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            new Login();
        } else {
            new SignUp();
        }
    }
}
