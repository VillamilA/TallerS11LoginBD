import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class bio extends JFrame {
    private JButton regresarButton;
    private JPanel biogra;
    private JButton VERBIOGRAFIAButton;

    public bio(){
    setTitle("Hobbies");
    setSize(400,500);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setContentPane(biogra);
        VERBIOGRAFIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarbio();
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new biografia().setVisible(true);
                dispose();
            }
        });
    }

    private void mostrarbio() {
        String url = "jdbc:mysql://localhost:3306/tallers11";
        String username = "root";
        String password = "123456";
        String sql = "SELECT * FROM biografia";

        try{
            Connection conexion = DriverManager.getConnection(url,username,password);
            Statement st = conexion.createStatement();
            ResultSet rst = st.executeQuery(sql);

            while(rst.next()){
                JOptionPane.showMessageDialog(null,
                        "| %s | %s | %s |%s | %s | %s | %s".formatted(rst.getString("idbiografia"), rst.getString("nombre"), rst.getString
                        ("apellido"), rst.getString("edad"), rst.getString("correo"), rst.getString
                                ("direccion"), rst.getString
                                ("carrera")));
            }
            conexion.close();
            st.close();
            rst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
