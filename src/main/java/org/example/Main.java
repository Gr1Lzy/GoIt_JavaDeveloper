package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;

public class Main {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        new DatabaseInitService().dbInit();

        ClientCrudService clientCrudService = new ClientCrudService(hibernateUtil);

        Client client = new Client();
        client.setName("Andrey");

        Client newClient = new Client();
        newClient.setName("John");
        clientCrudService.add(client);
        clientCrudService.updateById(12, newClient);
        System.out.println(clientCrudService.getAll());

        PlanetCrudService planetCrudService = new PlanetCrudService(hibernateUtil);
        Planet planet = new Planet();
        planet.setId("IV");
        planet.setName("Jupiter");
        planetCrudService.add(planet);

        TicketCrudService ticketCrudService = new TicketCrudService(hibernateUtil);
        System.out.println(ticketCrudService.getAll());
    }
}
