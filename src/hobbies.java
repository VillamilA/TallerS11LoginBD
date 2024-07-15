import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class hobbies extends JFrame {
    private JPanel hobbies;
    private JButton regresarButton;
    private JButton VERHOBBIESButton;

    public hobbies(){
    setTitle("Hobbies");
    setSize(400,500);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setContentPane(hobbies);

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new biografia().setVisible(true);
                dispose();
            }
        });
        VERHOBBIESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacion();
            }
        });
    }

    private void mostrarInformacion() {
        String url = "jdbc:mysql://localhost:3306/tallers11";
        String username = "root";
        String password = "123456";
        String sql = "SELECT * FROM hobbies";

        try{
            Connection conexion = DriverManager.getConnection(url,username,password);
            Statement st = conexion.createStatement();
            ResultSet rst = st.executeQuery(sql);

            while(rst.next()){
                JOptionPane.showMessageDialog(null, "%s | %s | %s |".formatted(rst.getString("idhobbies"), rst.getString("hobbies"), rst.getString
                        ("descripcion")));
                new hobbies().setVisible(true);
                dispose();
            }
            conexion.close();
            st.close();
            rst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}