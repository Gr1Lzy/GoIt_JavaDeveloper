package org.example;

import org.example.models.Client;
import org.example.services.ClientService;
import org.flywaydb.core.Flyway;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./test", null, null)
                .load();
        flyway.migrate();

        ClientService clientService = new ClientService(Database.getInstance().getConnection());
        Client client = new Client("Andrey");


        System.out.println("ID of created user: " + clientService.create(client.getName()));
        System.out.print(clientService.getById(1));

        clientService.setName(7, client.getName());
        clientService.deleteById(11);

        System.out.println(clientService.listAll());
    }
}