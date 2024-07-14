import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class biografia extends JFrame{
    private JPanel biogra;
    private JButton VERHOBBIESButton;
    private JButton VERBIOGRAFIAButton;
    private JTextArea textArea;
    public biografia() {
        setTitle("BIOGRAFIA");
        setSize(400,500);
        setContentPane(biogra);

        textArea = new JTextArea(15, 40);
        textArea.setEditable(false);

        VERBIOGRAFIAButton.addActionListener(new ActionListener() {
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
        String sql = "SELECT * FROM biografia";

        try{
            Connection conexion = DriverManager.getConnection(url,username,password);
            Statement st = conexion.createStatement();
            ResultSet rst = st.executeQuery(sql);

            while(rst.next()){
                JOptionPane.showMessageDialog(null, "%s | %s | %s | %s | %s | %s | %s".formatted(rst.getString("idbiografia"), rst.getString("nombre"), rst.getString
                        ("apellido"), rst.getString("edad"), rst.getString("correo"), rst.getString("direccion"), rst.getString("carrera")));
            }
            conexion.close();
            st.close();
            rst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
