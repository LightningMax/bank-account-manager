package models;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTables() {
        String sql =    "CREATE TABLE IF NOT EXISTS client ("
                        + "     id INTEGER PRIMARY KEY AUTO_INCREMENT,"
                        + "     name VARCHAR(255),"
                        + "     balance double"
                        + ");";

        try (
            Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tables created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createTables();
    }
}
