package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/vetclinic";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}