package br.com.alura.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertParamDB {
    public static void main(String[] args) throws SQLException {
        String nome = "keychron v2 1";
        String descricao = "best keyboard for programmer";
        //PreparedStatmente para evitar sql injection
        String sql = "INSERT produto(nome, descricao) VALUES(?, ?)";
        PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, nome);
        statement.setString(2, descricao);
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()) {
            System.out.println("Id: " + resultSet.getInt(1));
        }
    }
}
