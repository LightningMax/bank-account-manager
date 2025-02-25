package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:sqlite:bank.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            conn.createStatement().execute("PRAGMA foreign_keys = ON;");
            System.out.println("Connected to SQLite database.");
        } catch (SQLException e) {
            System.out.println("Connection failed" + e.getMessage());
        }
        return conn;
    }

    public static String getUrl() { return url; }

    public static void main(String[] args) {
        connect();
    }
}
