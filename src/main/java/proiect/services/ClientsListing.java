package proiect.services;

import proiect.models.Client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ClientsListing implements ClientsListingService {

    List<Client> clientsList = new ArrayList<>();

    @Override
    public void addClient(Client client) {
        clientsList.add(client);
        Comparator<Client> comparator = Comparator.comparing(client1 -> client.getFirstName());
        comparator = comparator.thenComparing(Comparator.comparing(client1 -> client1.getLastName()));
        clientsList.sort(comparator);
    }

    @Override
    public void showClients() {
        for(Client client : clientsList)
            System.out.println(client);
    }

    @Override
    public Optional<Client> getClient(String firstName, String lastName) {
        return clientsList.stream()
                .filter((client -> client.getFirstName().equals(firstName) && client.getLastName().equals(lastName)))
                .findFirst();
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }
}
