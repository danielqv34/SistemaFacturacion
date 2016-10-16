package com.dqv.clases;

import oracle.jdbc.driver.OracleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ezequ on 10/1/2016.
 */
public class Conexion {
    public static Connection getConnection() {
        String url = "jdbc:oracle:thin:@//localhost:1521/springcrud";
        String user = "c##dquiroz";
        String pass = "abc123";
        OracleConnection connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = (OracleConnection) DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
