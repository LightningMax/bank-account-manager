import controllers.ClientController;
import models.ClientDAO;
import models.DatabaseConnection;
import models.DatabaseSetup;
import views.CLIView;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.connect();       // Connect to sqlite database
        DatabaseSetup.createTables();       // Create tables

        ClientDAO clientDAO = new ClientDAO();
        ClientController clientController = new ClientController(clientDAO);

        CLIView cli = new CLIView(clientController);
        cli.displayLoginMenu();
    }
}
