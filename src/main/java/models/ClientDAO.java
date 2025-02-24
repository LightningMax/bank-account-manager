package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO {
    private Connection conn;

    public ClientDAO() {
        conn = DatabaseConnection.connect();
    }

    public void addClient(Client client) throws SQLException {
        String sql = "INSERT INTO client (name, password ,balance) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, client.getName());
        stmt.setString(2, client.getPassword());
        stmt.setDouble(3, client.getBalance());
        stmt.executeUpdate();
    }
}
