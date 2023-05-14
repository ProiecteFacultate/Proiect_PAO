package proiect.repository;

import proiect.models.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository {

    Optional<Vehicle> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Vehicle newObject);

    void addNewObject(Vehicle vehicle);

    List<Vehicle> getAll();

    void addAllFromGivenList(List<Vehicle> vehiclesList);
}
