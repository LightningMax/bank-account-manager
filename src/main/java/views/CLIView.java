package views;

import java.util.Scanner;

enum Command {
    EXIT, ADD_USER, DELETE_USER, DISPLAY_USER, FIND_USER, LIST_USERS, UNKNOWN;
    public static Command fromInt(int value) {
        switch (value) {
            case 0: return EXIT;
            case 1: return ADD_USER;
            case 2: return DELETE_USER;
            case 3: return DISPLAY_USER;
            case 4: return FIND_USER;
            case 5: return LIST_USERS;
            default: return UNKNOWN;
        }
    }
}

public class CLIView {
    Scanner scanner;

    public CLIView() {
        scanner = new Scanner(System.in);
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
            System.out.println("1 - Add user");
            System.out.println("2 - Delete user");
            System.out.println("3 - Display user");
            System.out.println("4 - Display all users");
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
                case ADD_USER: {
                    displayAddUser();
                }
            }
        }
    }

    public void displayAddUser() {

    }
}


