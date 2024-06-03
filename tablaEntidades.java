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



class tablaEntidades extends JFrame {
    public tablaEntidades(String url) {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("tipo de entidad");
        model.addColumn("ajustado");
        model.addColumn("ajuste");
        model.addColumn("vida");
        model.addColumn("daño");
        model.addColumn("buff(daño adaptable)");
        model.addColumn("buff(vida max)");

        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `entidades del mapa`");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vector<String> row = new Vector<>();
                row.add(resultSet.getString("ID"));
                row.add(resultSet.getString("nombre"));
                row.add(resultSet.getString("tipo de entidad"));
                row.add(resultSet.getString("ajustado"));
                row.add(resultSet.getString("ajuste"));
                row.add(resultSet.getString("vida"));
                row.add(resultSet.getString("daño"));
                row.add(resultSet.getString("oro"));
                row.add(resultSet.getString("buff(daño adaptable)"));
                row.add(resultSet.getString("buff(vida max)"));
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println("Error de BBDD: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setTitle("Tabla de entidades");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
