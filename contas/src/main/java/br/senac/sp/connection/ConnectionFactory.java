package br.senac.sp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://185.211.7.205/u553405907_fiap";
    private static final String USER = "u553405907_fiap";
    private static final String PASSWORD = "Senac@2022";

    private static Connection con;

    public static Connection getConnection() throws SQLException{
        if (con == null){
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        System.out.println("Criando conexão = " + con);
        return con;
    }
    
}
