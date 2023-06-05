package main.java.br.com.wineSquad.wineBar.domain.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() {
        try{
            return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/miniwinebar?user=root&password=root");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}