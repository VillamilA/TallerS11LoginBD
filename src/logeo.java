import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class logeo extends JFrame{
    private JTextField usu;
    private JPasswordField pass;
    private JButton ingresarButton;
    private JPanel logear;

    public logeo() {
        super("Login");
        setSize(400,500);
        setContentPane(logear);

        ingresarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = usu.getText();
                String contrasena = new String(pass.getPassword());

                if (validarlogin(cedula, contrasena)) {
                    JOptionPane.showMessageDialog(null, "Iniciaste Sesión de manera exitosa :D ");
                    new biografia().setVisible(true);
                    dispose();
                }
            }
        });
    }


    public boolean validarlogin(String cedula, String contrasena) {
        boolean validar = false;
        String url = "jdbc:mysql://localhost:3306/tallers11";
        String username = "root";
        String password = "123456";
        try {
            Connection conexion = DriverManager.getConnection(url, username, password);
            String sql = "select * from usuario where usuario =? and contrasena =?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, cedula);
            pst.setString(2, contrasena);
            ResultSet resultset = pst.executeQuery();
            if (resultset.next()) {
                validar = true;
            }
            resultset.close();
            pst.close();
            conexion.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validar;
    }

}