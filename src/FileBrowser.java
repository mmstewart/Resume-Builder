
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class FileBrowser extends JFrame {
    public JPanel p;
    public String s;

    public FileBrowser() {
        p = new JPanel();
        JFileChooser f = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int x = f.showOpenDialog(null);
        if (x == JFileChooser.APPROVE_OPTION) {
            s = f.getSelectedFile().getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(p, "Cancel Option Chosen, Closing Now");
            System.exit(-1);
        }
        f.setBounds(12, 0, 548, 326);
        p.add(f);
        p.setLayout(null);
    }

    public String getAbsolutePath() {
        return s;
    }
}