package proiect.repository;

import proiect.models.Client_Reservation;
import proiect.models.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Client_ReservationRepository {

    Optional<Client_Reservation> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Client_Reservation newObject);

    void addNewObject(Client_Reservation clientReservation);

    List<Client_Reservation> getAll();

    void addAllFromGivenList(List<Client_Reservation> clientReservationsList);
}
