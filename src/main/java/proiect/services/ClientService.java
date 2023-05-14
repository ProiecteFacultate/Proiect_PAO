package proiect.services;

import proiect.models.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    Optional<Client> getById(UUID id);

    Optional<Client> getByFirstNameAndLastName(String firstName, String lastName);

    List<Client> getAllFromList();

    void addOnlyOne(Client client);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Client newElement);

    void showAllClients();
}
