package br.com.alura.main;

import br.com.alura.dao.ProductDAO;
import br.com.alura.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class QueryDB {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().getConnection()) {
            var productDao = new ProductDAO(connection);

            List<Product> products =
                    productDao.getProductList();

            products.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
