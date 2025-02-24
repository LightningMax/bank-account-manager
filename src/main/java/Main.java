import controllers.ClientController;
import models.ClientDAO;
import views.CLIView;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        ClientController clientController = new ClientController(clientDAO);
        CLIView cli = new CLIView(clientController);

        cli.displayMainMenu();
    }
}
