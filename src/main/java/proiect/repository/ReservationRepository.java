package proiect.repository;

import proiect.models.Reservation;
import proiect.models.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {

    Optional<Reservation> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Reservation newObject);

    void addNewObject(Reservation reservation);

    List<Reservation> getAll();

    void addAllFromGivenList(List<Reservation> reservationsList);
}
