import models.Client;
import models.ClientDAO;
import views.ClientView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Client client = new Client("Joao", 450.0);
        ClientDAO clientDAO = new ClientDAO();
        ClientView clientView = new ClientView();

//        try {
//            clientDAO.addClient(client);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        clientView.displayClient(client);

    }
}
