package br.com.alura.main;

import java.sql.*;

public class QueryDB {
    public static void main(String[] args) throws SQLException {

        String query = "SELECT id as ID, nome AS Nome, descricao as `Descrição` FROM produto";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        boolean result = statement.execute();
        System.out.println("Resultado: " + result);

        ResultSet resultadoQuery = statement.getResultSet();
        while(resultadoQuery.next()) {
            System.out.println("Id: " + resultadoQuery.getInt("id"));
            System.out.println("Nome: " + resultadoQuery.getString("nome"));
            System.out.println("Descrição: " + resultadoQuery.getString("Descrição"));
        }

    }
}
