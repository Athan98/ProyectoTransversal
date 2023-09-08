/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alejo
 */
public class Conexion {

    private static String url;
    private static String usuario;
    private static String password;

    private static Connection conexion = null;

    public Conexion(String url,String user,String pass) {
        this.url = url;
        usuario = user;
        password = pass;
    }

    public Connection buscarConexion() {
         if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url,usuario,password);
                System.out.println("Conexion Exitosa");
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error, no se puede conectar ");
            }
         }
        return conexion;
    }

}

