package br.com.alura.main;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWD = "81172040*";

    private  DataSource dataSource;
    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(URL);
        comboPooledDataSource.setUser(USER);
        comboPooledDataSource.setPassword(PASSWD);

        comboPooledDataSource.setMaxPoolSize(15); //configurar máximo de conexões

        dataSource = comboPooledDataSource;
    }
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
