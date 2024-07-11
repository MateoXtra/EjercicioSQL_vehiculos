package Info_Vehiculos;
import Info_Vehiculos.ingreso_vehiculos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form2 {
    public JPanel buscar;
    private JTextField placabuscar;
    private JButton BUSCARButton;
    private JLabel prop;
    private JLabel marc;
    private JLabel cilin;

    public form2() {
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/vehiculos";
                String user = "root";
                String pass = "123456";

                try(Connection connection = DriverManager.getConnection(url,user,pass)){
                    System.out.println("Conexion a la base correcta");
                    String query = "SELECT * FROM info_vehiculos where placa= '"+placabuscar.getText()+"'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        prop.setText(resultSet.getString("propietario"));
                        marc.setText(resultSet.getString("marca"));
                        cilin.setText(resultSet.getString("cilindraje"));
                    }

                }catch (SQLException a){
                    System.out.println(a.getMessage());

                }
            }
        });
    }
}
