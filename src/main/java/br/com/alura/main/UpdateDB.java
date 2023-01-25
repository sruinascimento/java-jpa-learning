package br.com.alura.main;

import java.sql.*;

public class UpdateDB {
    public static void main(String[] args) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String nome = "Smartphone";
            String descricao = "Xiaomi Redmi Note 11";
            int id = 28;
            String sql = "UPDATE produto SET nome = ?, descricao = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, descricao);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();

            int result = preparedStatement.getUpdateCount();
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
