package br.com.alura.dao;

import br.com.alura.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Product product) {
        String sql = "INSERT INTO produto (nome, descricao) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getNome());
            preparedStatement.setString(2, product.getDescricao());

            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    System.out.println("Id: " + resultSet.getInt(1));
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> getProductList() {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getResultSet()) {

                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("nome");
                    String description = resultSet.getString("descricao");
                    products.add(new Product(id, name, description));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            int linesModified = preparedStatement.getUpdateCount();

            System.out.println("Registers removed: " + linesModified);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProductByCategory (Integer idCategory) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE categoria_id = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, idCategory);
            preparedStatement.execute();
            
            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("nome");
                    String descricao = resultSet.getString("descricao");
                    products.add(new Product(id, name, descricao));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

}
