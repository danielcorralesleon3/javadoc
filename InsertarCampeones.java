package gradle.wrapper;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class InsertarCampeones extends JFrame {
    private JTextField nombreTexto, vidaTexto, dañoTexto, rolTexto, ajusteTexto, itemMasUtilizadoTexto, mejorBuffTexto;
    private JCheckBox ajustadoCheckBox;
    

    public InsertarCampeones(String url) {
        setTitle("Insertar Campeón");
        setLayout(new GridLayout(9, 2));

        JLabel nombre = new JLabel("Nombre:");
        nombreTexto = new JTextField();
        JLabel vida = new JLabel("Vida:");
        vidaTexto = new JTextField();
        JLabel daño = new JLabel("Daño:");
        dañoTexto = new JTextField();
        JLabel rol = new JLabel("Rol:");
        rolTexto = new JTextField();
        JLabel ajustado = new JLabel("Ajustado:");
        ajustadoCheckBox = new JCheckBox();
        JLabel ajuste = new JLabel("Ajuste:");
        ajusteTexto = new JTextField();
        JLabel itemMasUtilizado = new JLabel("Item más Utilizado:");
        itemMasUtilizadoTexto = new JTextField();
        JLabel mejorBuff = new JLabel("Mejor Buff:");
        mejorBuffTexto = new JTextField();
        JButton botonInsertar = new JButton("Insertar");

        add(nombre);
        add(nombreTexto);
        add(vida);
        add(vidaTexto);
        add(daño);
        add(dañoTexto);
        add(rol);
        add(rolTexto);
        add(ajustado);
        add(ajustadoCheckBox);
        add(ajuste);
        add(ajusteTexto);
        add(itemMasUtilizado);
        add(itemMasUtilizadoTexto);
        add(mejorBuff);
        add(mejorBuffTexto);
        add(botonInsertar);

        botonInsertar.addActionListener(e -> insertarDatos(url));

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void insertarDatos(String url) {
            String nombre = nombreTexto.getText();
            int vida = Integer.parseInt(vidaTexto.getText());
            int daño = Integer.parseInt(dañoTexto.getText());
            String rol = rolTexto.getText();
            boolean ajustado = ajustadoCheckBox.isSelected();
            String ajuste = ajusteTexto.getText();
            int itemMasUtilizado = Integer.parseInt(itemMasUtilizadoTexto.getText());
            int mejorBuff = Integer.parseInt(mejorBuffTexto.getText());

            String insert = "INSERT INTO campeones (nombre, vida, daño, rol, ajustado, ajuste, `item mas utilizado`, `mejor buff`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try{
                Connection connection = DriverManager.getConnection(url, "root", "");
                PreparedStatement statement = connection.prepareStatement(insert);
                statement.setString(1, nombre);
                statement.setInt(2, vida);
                statement.setInt(3, daño);
                statement.setString(4, rol);
                statement.setBoolean(5, ajustado);
                statement.setString(6, ajuste);
                statement.setInt(7, itemMasUtilizado);
                statement.setInt(8, mejorBuff);
                statement.executeUpdate(); 
            } catch (SQLException e) {
                System.out.println("Error de BBDD: " + e.getMessage());
            }
       
    }
}
