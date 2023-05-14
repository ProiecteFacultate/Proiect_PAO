package proiect.services;

import proiect.models.Reservation;
import proiect.models.Reservation_Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Reservation_VehicleService {

    Optional<Reservation_Vehicle> getById(UUID id);

    List<Reservation_Vehicle> getAllFromList();

    void addOnlyOne(Reservation_Vehicle reservationVehicle);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Reservation_Vehicle newElement);
}
