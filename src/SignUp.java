import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SignUp extends JFrame implements ActionListener {
    public JLabel l, l1, l2, l3, l4;
    public JTextField t1;
    public JRadioButton b1, b2, b3;
    public ButtonGroup bg = new ButtonGroup();
    public JPasswordField t2, t3;
    public JButton b4;
    public Font f;
    private static final String UNICODE_FORMAT = "UTF-8";

    public SignUp() {
        f = new Font("SansSerif", Font.BOLD, 20);
        l = new JLabel("Sign Up");
        l.setFont(f);
        l1 = new JLabel("Username:");
        l2 = new JLabel("Password:");
        l3 = new JLabel("Confirm Password:");
        l4 = new JLabel("");
        t1 = new JTextField();
        t2 = new JPasswordField();
        t3 = new JPasswordField();
        b4 = new JButton("Sign Up");
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        l.setBounds(150, 10, 100, 100);
        l1.setBounds(50, 100, 100, 40);
        l2.setBounds(50, 140, 100, 40);
        l3.setBounds(50, 180, 200, 40);
        t1.setBounds(200, 100, 200, 40);
        t2.setBounds(200, 140, 200, 40);
        t3.setBounds(200, 180, 200, 40);
        b4.setBounds(160, 380, 100, 50);
        b4.addActionListener(this);
        add(b4);
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(t2);
        add(t3);
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
    }

    public static SecretKey generateKey(String encryptionType) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptionType);
            keyGenerator.init(256);
            SecretKey mKey = keyGenerator.generateKey();
            return mKey;
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] encryptString(String dataToEncrypt, SecretKey mKey, Cipher cipher) {
        try {
            byte[] text = dataToEncrypt.getBytes(UNICODE_FORMAT);
            cipher.init(Cipher.ENCRYPT_MODE, mKey);
            byte[] textEncrypted = cipher.doFinal(text);
            return textEncrypted;
        } catch (Exception e) {
            return null;
        }
    }

    public void actionPerformed(ActionEvent e) {
        String s1 = new String(t2.getPassword());
        String s2 = new String(t3.getPassword());
        if (s1.equals(s2) && !t1.getText().isEmpty()) {
            String fileName = "/Users/Marcus/Desktop/" + t1.getText().trim() + ".txt";
            File fi = new File(fileName);
            try (FileWriter writer = new FileWriter(fi)) {
                SecretKey key = generateKey("AES");
                Cipher chipher = Cipher.getInstance("AES");

                byte[] encryptedData = encryptString(s1, key, chipher);
                String encryptString = new String(encryptedData);
                writer.write(encryptString);
                System.out.println(encryptString);
            } catch (Exception s) {
                System.out.println(s);
            }
            new Login();
        } else if (t1.getText().isEmpty()) {
            JOptionPane jop = new JOptionPane(l4, JOptionPane.WARNING_MESSAGE);
            jop.showMessageDialog(l4, "Fill in the missing information.");
        } else {
            JOptionPane jop = new JOptionPane(l4, JOptionPane.WARNING_MESSAGE);
            jop.showMessageDialog(l4, "Passwords are not the same.");
        }
    }
}
