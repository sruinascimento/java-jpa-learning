package br.com.alura.main;

import java.sql.*;

public class InsertParamDB {
    public static void main(String[] args) throws SQLException {
       /* String nome = "keychron v2 1";
        String descricao = "best keyboard for programmer";*/
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.getConnection()) {
            connection.setAutoCommit(false); //controlar transação, logo, podemos excluir dados caso haja exceção
            String sql = "INSERT produto(nome, descricao) VALUES(?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                insertDataOnDB("Mouse Razer", 1, "Custo benefício", 2, preparedStatement);
                insertDataOnDB("Monitor Aoc", 1, "Best Seller", 2, preparedStatement);
                insertDataOnDB("SmartTV", 1, "32 Polegadas", 2, preparedStatement);

                connection.commit();
            } catch (SQLException exception) {
                exception.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                connection.rollback();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void insertDataOnDB(String nome, int indexNome, String descricao, int indexDescricao, PreparedStatement preparedStatement) throws SQLException {
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
    }
}
