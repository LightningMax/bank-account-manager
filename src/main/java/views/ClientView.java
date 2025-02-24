package views;

import models.Client;

public class ClientView {
    public void displayClient(Client client) {
        System.out.println("Client: " + client.getName() + " - Balance: " + client.getBalance());
    }
}
