package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    private Connection conn;

    public ClientDAO() {
        conn = DatabaseConnection.connect();
    }

    public void addClient(Client client) throws SQLException {
        String sql = "INSERT INTO client (name, password, balance) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, client.getName());
        stmt.setString(2, client.getPassword());
        stmt.setDouble(3, client.getBalance());
        stmt.executeUpdate();
    }

    public Client getUserByName(String name) throws SQLException {
        String sql = "SELECT name, password, balance FROM client WHERE name = ? ";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                String password = rs.getString("password");
                double balance = rs.getDouble("balance");

                return new Client(name, password, balance);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching user " + e.getMessage());
        }

        return null;
    }
}
