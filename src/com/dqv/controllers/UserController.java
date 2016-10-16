package com.dqv.controllers;

import com.dqv.clases.Conexion;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import java.sql.SQLException;


/**
 * Created by ezequ on 10/2/2016.
 */
public class UserController {
    OraclePreparedStatement preparedStatement;
    OracleConnection connection;
    OracleResultSet resultSet;

    public boolean validarUsuario(String user, String pass) {
        try {
            String query = "select 1 from USUARIOS_FAC where NOMBRE_USUARIO = ? and CLAVE =?";
            connection = (OracleConnection) Conexion.getConnection();
            preparedStatement = (OraclePreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            resultSet = (OracleResultSet) preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int obtenerPerfil(String nombreUsuario) {
        try {
            String query = "select ROL from USUARIOS_FAC where NOMBRE_USUARIO = ?";
            connection = (OracleConnection) Conexion.getConnection();
            preparedStatement = (OraclePreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, nombreUsuario);

            resultSet = (OracleResultSet) preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("ROL");
            } else {
                return -1;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
