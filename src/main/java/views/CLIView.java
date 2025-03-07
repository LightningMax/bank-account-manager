package views;

import controllers.ClientController;
import models.Client;

import java.util.Scanner;

enum Command {
    EXIT, LOGIN, CREATE_ACCOUNT, UNKNOWN;
    public static Command fromInt(int value) {
        switch (value) {
            case 0: return EXIT;
            case 1: return LOGIN;
            case 2: return CREATE_ACCOUNT;
            default: return UNKNOWN;
        }
    }
}

public class CLIView {
    Scanner scanner;
    private ClientController clientController;

    public CLIView(ClientController clientController) {
        scanner = new Scanner(System.in);
        this.clientController = clientController;
    }

    public void ascii_art() {
        System.out.println("  ____              _        _                ");
        System.out.println(" | __ )  __ _ _ __ | | __   / \\   _ __  _ __  ");
        System.out.println(" |  _ \\ / _` | '_ \\| |/ /  / _ \\ | '_ \\| '_ \\ ");
        System.out.println(" | |_) | (_| | | | |   <  / ___ \\| |_) | |_) |");
        System.out.println(" |____/ \\__,_|_| |_|_|\\_\\/_/   \\_\\ .__/| .__/ ");
        System.out.println("                                 |_|   |_|    ");
        System.out.println("====================================================");
    }

    public void displayLoginMenu() {

        int choice = -1;

        while (true) {

            ascii_art();
            System.out.println("1 - Login");
            System.out.println("2 - Create Account");
            System.out.println("0 - Exit");
            System.out.print("> ");

            choice = Integer.parseInt(scanner.nextLine());
            Command command = Command.fromInt(choice);

            switch (command) {
                case EXIT: {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                case LOGIN: {
                    displayLogin();
                    return;
                }
                case CREATE_ACCOUNT: {
                    displayCreateAccount();
                    break;
                }
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    public void displayMainMenu(Client client) {
        ascii_art();
        System.out.println("Hello " + client.getName());
        System.out.println("Your balance: " + client.getBalance());
    }

    public void displayCreateAccount() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        clientController.createAccount(name, password);
    }

    public void displayLogin() {
        Client client = null;

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();


        client = clientController.login(name, password);

        if (client == null) {
            System.out.println("Login failed");
            return;
        }

        displayMainMenu(client);
    }
}
