package br.com.alura.main;

import java.sql.SQLException;

public class PoolConnection {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory coneConnectionFactory = new ConnectionFactory();
        for (int i = 0; i < 20; i++) {
            coneConnectionFactory.getConnection();
            System.out.println("Conexão de número " + i);
        }
    }
}
