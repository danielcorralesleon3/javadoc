package gradle.wrapper;

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


class tablaChamp extends JFrame {
    public tablaChamp(String url) {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Vida");
        model.addColumn("Daño");
        model.addColumn("Rol");
        model.addColumn("Ajustado");
        model.addColumn("Ajuste");
        model.addColumn("Item más utilizado");
        model.addColumn("Mejor buff");

        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM campeones");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vector<String> row = new Vector<>();
                row.add(resultSet.getString("ID"));
                row.add(resultSet.getString("Nombre"));
                row.add(resultSet.getString("vida"));
                row.add(resultSet.getString("daño"));
                row.add(resultSet.getString("Rol"));
                row.add(resultSet.getString("ajustado"));
                row.add(resultSet.getString("ajuste"));
                row.add(resultSet.getString("Item mas utilizado"));
                row.add(resultSet.getString("mejor buff"));
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println("Error de BBDD: " + e.getMessage());
        }


        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        
        setTitle("Tabla de Campeones");
        setSize(800, 400);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
