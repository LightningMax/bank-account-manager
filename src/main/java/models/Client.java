package models;

public class Client {
    private int id;
    private String name;
    private String password;
    private double balance;

    public Client(String name, String password, double initial_balance) {
        this.setName(name);
        this.setPassword(password);
        this.setBalance(initial_balance);
    };

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

    public String getPassword() {
        return password;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
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
