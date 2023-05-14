package proiect.services.impl;

import lombok.RequiredArgsConstructor;
import proiect.enums.VehicleType;
import proiect.models.Reservation;
import proiect.models.Vehicle;
import proiect.repository.ReservationRepository;
import proiect.services.ReservationService;

import java.util.*;

@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Optional<Reservation> getById(UUID id) {
        return reservationRepository.getObjectById(id);
    }

    @Override
    public List<Reservation> getAllFromList() {
        return reservationRepository.getAll();
    }

    @Override
    public void addOnlyOne(Reservation reservation) {
        reservationRepository.addNewObject(reservation);
    }

    @Override
    public void removeElementById(UUID id) {
        reservationRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Reservation newElement) {
        reservationRepository.updateObjectById(id, newElement);
    }

    @Override
    public Map<Vehicle, Integer> makeReservation(VehicleType vehicleType, int seatsRequired, List<Vehicle> allVehicles) {
        int totalSeatsAvailable = 0;
        Map<Vehicle, Integer> reservedVehicles = new HashMap<>();

        for(Vehicle vehicle : allVehicles)
            if(vehicle.getVehicleType().equals(vehicleType))
                totalSeatsAvailable += vehicle.getCapacity() - vehicle.getNumberOfReservedSeats();

        if(totalSeatsAvailable >= seatsRequired)
            for(Vehicle vehicle : allVehicles)
                if(vehicle.getVehicleType().equals(vehicleType)) {
                    int seatsAvailable = vehicle.getCapacity() - vehicle.getNumberOfReservedSeats();
                    if(seatsAvailable >= seatsRequired) {
                        reservedVehicles.put(vehicle, seatsRequired);
                        return reservedVehicles;
                    } else {
                        reservedVehicles.put(vehicle, seatsAvailable);
                        seatsRequired -= seatsAvailable;
                    }
                }

        return reservedVehicles;
    }
}
