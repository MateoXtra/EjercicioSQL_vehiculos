package Info_Vehiculos;
import Info_Vehiculos.ingreso_vehiculos;
import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ingreso_vehiculos {
    public JPanel datos;
    private JButton INGRESARButton;
    private JButton BORRARButton;
    private JButton BUSCARPORPLACAButton;
    private JTextField placa;
    private JTextField marca;
    private JTextField cilindraje;
    private JTextField combustible;
    private JTextField color;
    private JTextField propietario;

    public ingreso_vehiculos() {
        INGRESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/vehiculos";
                String user = "root";
                String pass = "123456";

                vehiculos vehiculo1 = new vehiculos();
                String placa1 = placa.getText();
                String marca1 = marca.getText();
                Double cilindraje1 = Double.parseDouble(cilindraje.getText());
                String combustible1 = combustible.getText();
                String color1 = color.getText();
                String propietario1 = propietario.getText();

                vehiculo1.setPlaca(placa1);
                vehiculo1.setMarca(marca1);
                vehiculo1.setCilindraje(cilindraje1);
                vehiculo1.setTipo_combustible(combustible1);
                vehiculo1.setColor(color1);
                vehiculo1.setPropietario(propietario1);

                String sql = "INSERT INTO info_vehiculos (placa, marca, cilindraje, tipo_combustible, color, propietario) VALUES (?,?,?,?,?,?)";

                try (Connection connection = DriverManager.getConnection(url,user,pass)){
                    System.out.println("BASE DE DATOS CONECTADA CORRECTAMENTE");
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,placa1);
                    preparedStatement.setString(2,marca1);
                    preparedStatement.setDouble(3,cilindraje1);
                    preparedStatement.setString(4,combustible1);
                    preparedStatement.setString(5,color1);
                    preparedStatement.setString(6,propietario1);
                    preparedStatement.executeUpdate();
                }catch (SQLException E){
                    System.out.println(E);
                }
            }
        });
        BORRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placa.setText("");
                marca.setText("");
                cilindraje.setText("");
                combustible.setText("");
                color.setText("");
                propietario.setText("");
            }
        });
        BUSCARPORPLACAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new form2().buscar);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800,600);
                frame.setVisible(true);
                frame.pack();
                ((JFrame) SwingUtilities.getWindowAncestor(BUSCARPORPLACAButton)).dispose();
            }
        });
    }
}
