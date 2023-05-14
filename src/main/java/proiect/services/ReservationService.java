package proiect.services;

import proiect.enums.VehicleType;
import proiect.models.Reservation;
import proiect.models.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface ReservationService {

    Optional<Reservation> getById(UUID id);

    List<Reservation> getAllFromList();

    void addOnlyOne(Reservation reservation);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Reservation newElement);

    Map<Vehicle, Integer> makeReservation(VehicleType vehicleType, int seatsRequired, List<Vehicle> allVehicles);
}
