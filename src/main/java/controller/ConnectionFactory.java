package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection createConnectionPostgres() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");

        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = createConnectionPostgres();

        if(con!= null){
            System.out.println("Conectado");
            con.close();
        }
    }


}
