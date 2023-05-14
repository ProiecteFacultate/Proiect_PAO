package proiect.services.impl;

import lombok.RequiredArgsConstructor;
import proiect.models.Client_Reservation;
import proiect.models.Reservation;
import proiect.repository.Client_ReservationRepository;
import proiect.services.Client_ReservationService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class Client_ReservationServiceImpl implements Client_ReservationService {

    private final Client_ReservationRepository clientReservationRepository;

    @Override
    public Optional<Client_Reservation> getById(UUID id) {
        return clientReservationRepository.getObjectById(id);
    }

    @Override
    public List<Client_Reservation> getAllFromList() {
        return clientReservationRepository.getAll();
    }

    @Override
    public void addOnlyOne(Client_Reservation clientReservation) {
        clientReservationRepository.addNewObject(clientReservation);
    }

    @Override
    public void removeElementById(UUID id) {
        clientReservationRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Client_Reservation newElement) {
        clientReservationRepository.updateObjectById(id, newElement);
    }

    @Override
    public List<UUID> getAllReservationsByClient(UUID clientId) {
        return clientReservationRepository.findAllReservationsByClient(clientId);
    }
}
