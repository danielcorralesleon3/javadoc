package gradle.wrapper;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class filtrovida extends JFrame {
    private DefaultTableModel modelo;
    private JTable tabla;
    private Connection conexion;

    public filtrovida(String url) {
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Vida");
        modelo.addColumn("Daño");
        modelo.addColumn("Rol");
        modelo.addColumn("Ajustado");
        modelo.addColumn("Ajuste");
        modelo.addColumn("Item más utilizado");
        modelo.addColumn("Mejor buff");

        try {
            conexion = DriverManager.getConnection(url, "root", "");
            cargarDatosTablaOrdenada();

        } catch (SQLException e) {
            System.out.println("Error de BBDD: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        setTitle("Tabla Ordenada por Vida");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void cargarDatosTablaOrdenada() {
        modelo.setRowCount(0);
        String consulta = "SELECT * FROM campeones ORDER BY vida DESC";

        try {
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vector<String> fila = new Vector<>();
                fila.add(resultSet.getString("ID"));
                fila.add(resultSet.getString("Nombre"));
                fila.add(resultSet.getString("vida"));
                fila.add(resultSet.getString("daño"));
                fila.add(resultSet.getString("Rol"));
                fila.add(resultSet.getString("ajustado"));
                fila.add(resultSet.getString("ajuste"));
                fila.add(resultSet.getString("Item mas utilizado"));
                fila.add(resultSet.getString("mejor buff"));
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error de BBDD: " + e.getMessage());
        }
    }
}
