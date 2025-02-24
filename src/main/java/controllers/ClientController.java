package controllers;

import models.Client;
import models.ClientDAO;

import java.sql.SQLException;

public class ClientController {
    private ClientDAO clientDAO;

    public ClientController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    };

    public void createAccount(String name, String password, double initialBalance) {
        Client client = new Client(name, password, initialBalance);

        try {
            clientDAO.addClient(client);
        } catch (SQLException e) {
            System.out.println("Account creation failed " + e.getMessage());
        }

        System.out.println("Account created successfully!");
    }
}
