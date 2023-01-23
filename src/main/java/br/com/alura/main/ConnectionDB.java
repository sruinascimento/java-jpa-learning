package br.com.alura.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
        final String USER = "root";
        final String PASSWD = "81172040*";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("Conexão bem sucedida!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
