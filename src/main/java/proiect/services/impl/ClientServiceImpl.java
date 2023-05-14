package proiect.services.impl;

import lombok.RequiredArgsConstructor;
import proiect.models.Client;
import proiect.repository.ClientRepository;
import proiect.services.ClientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Optional<Client> getById(UUID id) {
        return clientRepository.getObjectById(id);
    }

    @Override
    public Optional<Client> getByFirstNameAndLastName(String firstName, String lastName) {
        return clientRepository.getByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Client> getAllFromList() {
        return clientRepository.getAll();
    }

    @Override
    public void addOnlyOne(Client client) {
        clientRepository.addNewObject(client);
    }

    @Override
    public void removeElementById(UUID id) {
        clientRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Client newElement) {
        clientRepository.updateObjectById(id, newElement);
    }

    @Override
    public void showAllClients() {
        for (Client client : getAllFromList())
            System.out.println(client);
    }
}
