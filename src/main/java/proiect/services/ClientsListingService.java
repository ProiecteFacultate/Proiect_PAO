package proiect.services;

import proiect.models.Client;

import java.util.Optional;

public interface ClientsListingService {

    void addClient(Client client);
    void showClients();
    Optional<Client> getClient(String firstName, String lastName);
}
