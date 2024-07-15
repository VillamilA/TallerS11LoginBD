import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class biografia extends JFrame{
    private JPanel menu;
    private JButton VERHOBBIESButton;
    private JButton VERBIOGRAFIAButton;
    private JTextArea textArea;
    public biografia() {
        setTitle("BIOGRAFIA");
        setSize(400,500);
        setContentPane(menu);

        textArea = new JTextArea(15, 40);
        textArea.setEditable(false);

        VERBIOGRAFIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new bio().setVisible(true);
                dispose();

            }
        });
        VERHOBBIESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new hobbies().setVisible(true);
                dispose();
            }
        });
    }

}
