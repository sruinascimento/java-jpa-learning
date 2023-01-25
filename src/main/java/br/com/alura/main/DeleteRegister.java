package br.com.alura.main;


import java.sql.*;

public class DeleteRegister {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        int idMin = 15;
        String sql = "DELETE FROM produto WHERE id > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, idMin);
        preparedStatement.execute();
        int linesModified = preparedStatement.getUpdateCount();
        System.out.println("Linhas apagadas " + linesModified);

    }
}
