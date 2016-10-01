package Clases;


import oracle.jdbc.driver.OracleConnection;

import javax.swing.*;
import java.sql.*;

/**
 * Created by DanielQuirozV on 10/31/2015.
 */


public class AplicattionController {

    public static Connection GetConnection() {
        String url = "jdbc:oracle:thin:@//localhost:1521/springcrud";
        String user = "c##dquiroz";
        String pass = "abc123";
        OracleConnection connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = (OracleConnection) DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion con Oracle Exitosa");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public boolean validarUsuario(String nombre, String contrasenia) {
        if (nombre.equals("daniel") && contrasenia.equals("abc123")) {
            return true;
        } else {
            return false;
        }
    }


}

