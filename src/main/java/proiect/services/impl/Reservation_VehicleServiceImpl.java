package proiect.services.impl;

import lombok.RequiredArgsConstructor;
import proiect.models.Reservation_Vehicle;
import proiect.repository.Reservation_VehicleRepository;
import proiect.services.Reservation_VehicleService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class Reservation_VehicleServiceImpl implements Reservation_VehicleService {

    private final Reservation_VehicleRepository reservationVehicleRepository;

    @Override
    public Optional<Reservation_Vehicle> getById(UUID id) {
        return reservationVehicleRepository.getObjectById(id);
    }

    @Override
    public List<Reservation_Vehicle> getAllFromList() {
        return reservationVehicleRepository.getAll();
    }

    @Override
    public void addOnlyOne(Reservation_Vehicle reservationVehicle) {
        reservationVehicleRepository.addNewObject(reservationVehicle);
    }

    @Override
    public void removeElementById(UUID id) {
        reservationVehicleRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Reservation_Vehicle newElement) {
        reservationVehicleRepository.updateObjectById(id, newElement);
    }
}
