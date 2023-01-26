package br.com.alura.main;

import br.com.alura.model.Product;

import java.sql.*;

public class InsertProduct {
    public static void main(String[] args) throws SQLException {
        var cellphone = new Product("Iphone Pro Max", "Ultima geracao");

        try (Connection connection = new ConnectionFactory().getConnection()) {
            String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, cellphone.getNome());
                preparedStatement.setString(2, cellphone.getDescricao());
                preparedStatement.execute();

                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        Integer id = resultSet.getInt(1);
                        System.out.println("Id gerado: " + id);
                        cellphone.setId(id);
                    }
                }
            }

        }

        System.out.println(cellphone);
    }
}
