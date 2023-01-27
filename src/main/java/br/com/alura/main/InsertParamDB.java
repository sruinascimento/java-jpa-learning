package br.com.alura.main;

import br.com.alura.model.Product;
import br.com.alura.dao.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertParamDB {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.getConnection()) {
            var productDao = new ProductDAO(connection);
            productDao.save(new Product("Ryzen 7-5800X", "processador top"));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*private static void insertDataOnDB(String nome, int indexNome, String descricao, int indexDescricao, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(indexNome, nome);
        preparedStatement.setString(indexDescricao, descricao);

        preparedStatement.execute();

        try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }*/
}
