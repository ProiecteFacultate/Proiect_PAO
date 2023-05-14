package proiect.services;

import proiect.models.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleService {

    Optional<Vehicle> getById(UUID id);

    List<Vehicle> getAllFromList();

    void addOnlyOne(Vehicle vehicle);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Vehicle newElement);

    int getSoldSeatsValue();

    int getCompanyIncomingEarnings();

    List<Vehicle> getFullVehicles();

    List<Vehicle> getEmptyVehicles();

    void reserveSeats(UUID id, int numberOfSeats);
}
