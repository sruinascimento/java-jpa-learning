package br.com.alura.dao;

import br.com.alura.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Category> getCategoryList() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM categoria";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("nome");
                    categories.add(new Category(id, name));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
