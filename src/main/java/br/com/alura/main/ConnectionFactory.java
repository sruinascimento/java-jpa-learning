package br.com.alura.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
        final String USER = "root";
        final String PASSWD = "81172040*";
        return DriverManager.getConnection(URL, USER, PASSWD);
    }
}
