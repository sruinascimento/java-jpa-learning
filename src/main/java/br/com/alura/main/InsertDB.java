package br.com.alura.main;

import java.sql.*;

public class InsertDB {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            System.out.println("Sucesso!");
            String nome = "Smartphone'";
            String descricao = "Xiaomi Redmi Note 11'";
            String sql = "INSERT INTO produto(nome, descricao) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, descricao);
                preparedStatement.execute();
                try (ResultSet result = preparedStatement.getGeneratedKeys()) {
                    while (result.next()) {
                        System.out.println("Id: " + result.getInt(1));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
