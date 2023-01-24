package br.com.alura.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO produto(nome, descricao) VALUES";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
