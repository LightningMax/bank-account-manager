package models;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createClientsTable() {
        String sql =  "CREATE TABLE IF NOT EXISTS clients ("
                + "     client_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "     name TEXT NOT NULL,"
                + "     password TEXT NOT NULL"
                + ");";

        try (
                Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public static void createAccountsTable() {
        String sql =  "CREATE TABLE IF NOT EXISTS accounts ("
                    + "     account_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "     client_id INTEGER NOT NULL,"
                    + "     balance REAL NOT NULL,"
                    + "     FOREIGN KEY (client_id) REFERENCES client (client_id)"
                    + ");";

        try (
                Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Table created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public static void createTransactionsTable() {
        String sql =  "CREATE TABLE IF NOT EXISTS transactions ("
                    + "     transaction_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "     account_id INTEGER NOT NULL,"
                    + "     type TEXT NOT NULL,"
                    + "     amount REAL NOT NULL,"
                    + "     transaction_timestamp DATETIME,"
                    + "     FOREIGN KEY(account_id) REFERENCES account(account_id)"
                    + ");";

        try (
                Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Table created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public static void createTables() {
        DatabaseSetup.createClientsTable();
        DatabaseSetup.createAccountsTable();
        DatabaseSetup.createTransactionsTable();
    }

    public static void main(String[] args) {
        createTables();
    }
}
