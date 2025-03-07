package controllers;

import models.Client;
import models.ClientDAO;

import java.sql.SQLException;

public class ClientController {
    private ClientDAO clientDAO;

    public ClientController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    };

    public void createAccount(String name, String password) {
        Client client = new Client(name, password);

        try {
            clientDAO.addClient(client);
            System.out.println("Client created successfully!");
        } catch (SQLException e) {
            System.out.println("Client creation failed " + e.getMessage());
        }
    }

//    public void login(String name, String password) {
//        try {
//            Client client = clientDAO.getUserByName(name);
//
//            if (client == null) {
//                System.out.println("User not found");
//                return;
//            }
//            System.out.println("User found with success!");
//        } catch (SQLException e) {
//            System.out.println("Error fetching user " + e.getMessage());
//        }
//    }
}
