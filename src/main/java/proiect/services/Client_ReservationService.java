package proiect.services;

import proiect.models.Client_Reservation;
import proiect.models.Reservation;
import proiect.models.Reservation_Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Client_ReservationService {

    Optional<Client_Reservation> getById(UUID id);

    List<Client_Reservation> getAllFromList();

    void addOnlyOne(Client_Reservation clientReservation);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Client_Reservation newElement);

    List<UUID> getAllReservationsByClient(UUID clientId);
}
