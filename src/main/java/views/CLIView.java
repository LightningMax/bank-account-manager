package views;

import controllers.ClientController;

import java.util.Scanner;

enum Command {
    EXIT, LOGIN, LOGOUT , CREATE_ACCOUNT, UNKNOWN;
    public static Command fromInt(int value) {
        switch (value) {
            case 0: return EXIT;
            case 1: return LOGIN;
            case 2: return LOGOUT;
            case 3: return CREATE_ACCOUNT;
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

    public void displayMainMenu() {

        int choice = -1;

        while (true) {

            System.out.println("   ____ _ _            _      _ ");
            System.out.println("  / ___| (_) ___ _ __ | |_   / \\   _ __  _ __ ");
            System.out.println(" | |   | | |/ _ \\ '_ \\| __| / _ \\ | '_ \\| '_ \\ ");
            System.out.println(" | |___| | |  __/ | | | |_ / ___ \\| |_) | |_) | ");
            System.out.println("  \\____|_|_|\\___|_| |_|\\__/_/   \\_\\ .__/| .__/ ");
            System.out.println("                                 |_|   |_|    ");
            System.out.println("====================================================");
            System.out.println("1 - Login");
            System.out.println("2 - Logout");
            System.out.println("2 - Create Account");
            System.out.println("0 - Exit");
            System.out.println("> ");

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
                    break;
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

    public void displayLogin() {

    }

    public void displayCreateAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        System.out.println("Enter your initial balance: ");
        double initialBalance = scanner.nextDouble();

        clientController.createAccount(name, password, initialBalance);
    }
}
