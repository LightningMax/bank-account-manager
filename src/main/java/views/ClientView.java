package views;

import controllers.ClientController;
import models.Client;

import java.util.Scanner;

public class ClientView {
    public void displayClient(Client client) {
        System.out.println("Client: " + client.getName() + " - Balance: " + client.getBalance());
    }

    public static void registerAccount() {

//        ClientController.createAccount(name, password, initialBalance);
    }
}
