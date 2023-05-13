package proiect.repository;

import proiect.models.Reservation_Vehicle;
import proiect.models.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Reservation_VehicleRepository {

    Optional<Reservation_Vehicle> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Reservation_Vehicle newObject);

    void addNewObject(Reservation_Vehicle reservationVehicle);

    List<Reservation_Vehicle> getAll();

    void addAllFromGivenList(List<Reservation_Vehicle> reservationVehiclesList);
}
