package br.com.alura.main;

import br.com.alura.dao.CategoryDAO;
import br.com.alura.dao.ProductDAO;
import br.com.alura.model.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class QueryCategory {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.getConnection() ) {
            var categoryDao = new CategoryDAO(connection);
            var productDAO = new ProductDAO(connection);
            List<Category> categories = categoryDao.getCategoryList();
            categories.forEach(category -> {
                System.out.println("Category: " + category.getName());
                productDAO.getProductByCategory(category.getId())
                        .forEach(product -> System.out.println("Name: " + product.getNome()));
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
