package models;

public class Client {
    private int id;
    private String name;
    private double balance;

    Client() {};

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        }
        else {
            System.out.println("Could not set balance");
        }
    }

}
