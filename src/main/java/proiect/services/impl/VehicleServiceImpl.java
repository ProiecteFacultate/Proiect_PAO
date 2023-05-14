package proiect.services.impl;

import lombok.RequiredArgsConstructor;
import proiect.models.Vehicle;
import proiect.repository.VehicleRepository;
import proiect.services.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Optional<Vehicle> getById(UUID id) {
        return vehicleRepository.getObjectById(id);
    }

    @Override
    public List<Vehicle> getAllFromList() {
        return vehicleRepository.getAll();
    }

    @Override
    public void addOnlyOne(Vehicle vehicle) {
        vehicleRepository.addNewObject(vehicle);
    }

    @Override
    public void removeElementById(UUID id) {
        vehicleRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Vehicle newElement) {
        vehicleRepository.updateObjectById(id, newElement);
    }

    @Override
    public int getSoldSeatsValue() {
        int value = 0;

        for (Vehicle vehicle : getAllFromList())
            value += vehicle.getCapacity() * vehicle.getPrice();

        return value;
    }

    @Override
    public int getCompanyIncomingEarnings() {
        int value = 0;

        for (Vehicle vehicle : getAllFromList())
            value += vehicle.getNumberOfReservedSeats() * vehicle.getPrice();

        return value;
    }

    @Override
    public List<Vehicle> getFullVehicles() {
        List<Vehicle> fullVehicles = new ArrayList<>();

        for(Vehicle vehicle : getAllFromList())
            if(vehicle.getNumberOfReservedSeats().equals(vehicle.getCapacity()))
                fullVehicles.add(vehicle);

        return fullVehicles;
    }

    @Override
    public List<Vehicle> getEmptyVehicles() {
        List<Vehicle> emptyVehicles = new ArrayList<>();

        for(Vehicle vehicle : getAllFromList())
            if(vehicle.getNumberOfReservedSeats() == 0)
                emptyVehicles.add(vehicle);

        return emptyVehicles;
    }

    @Override
    public void reserveSeats(UUID id, int numberOfSeats) {
        Vehicle vehicle = getById(id).get();
        vehicle.setNumberOfReservedSeats(vehicle.getNumberOfReservedSeats() + numberOfSeats);
        modificaElementById(id, vehicle);
    }
}
