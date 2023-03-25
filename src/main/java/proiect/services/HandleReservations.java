package proiect.services;

import proiect.models.*;

import java.util.*;

public class HandleReservations {

    public Map<Vehicle, Integer> makeReservation(CompanyService company, String vehicleType, int seatsRequired) {
        switch (vehicleType.toLowerCase()) {
            case "bus":
                return reserve(company, new Bus(), seatsRequired);
            case "train":
                return reserve(company, new Train(), seatsRequired);
            case "plane":
                return reserve(company, new Plane(), seatsRequired);
            case "helicopter":
                return reserve(company, new Helicopter(), seatsRequired);
            case "yacht":
                return reserve(company, new Yacht(), seatsRequired);
            case "sailboat":
                return reserve(company, new SailBoat(), seatsRequired);
            default:
                return new HashMap<>();
        }
    }

    private Map<Vehicle, Integer> reserve(CompanyService company, Vehicle vehicleType, int seatsRequired) {
        int totalSeatsAvailable = 0;
        Map<Vehicle, Integer> reservedVehicles = new HashMap<>();

        for(Vehicle vehicle : ((Company) company).getVehicleList())
            if(vehicle.getClass().equals(vehicleType.getClass()))
                totalSeatsAvailable += vehicle.getCapacity() - vehicle.getNumberOfReservedSeats();

        if(totalSeatsAvailable >= seatsRequired)
            for(Vehicle vehicle : ((Company) company).getVehicleList())
                if(vehicle.getClass().equals(vehicleType.getClass())) {
                    int seatsAvailable = vehicle.getCapacity() - vehicle.getNumberOfReservedSeats();
                    if(seatsAvailable >= seatsRequired) {
                        reservedVehicles.put(vehicle, seatsRequired);
                        vehicle.setNumberOfReservedSeats(vehicle.getNumberOfReservedSeats() + seatsRequired);
                        return reservedVehicles;
                    } else {
                        vehicle.setNumberOfReservedSeats(vehicle.getCapacity());
                        reservedVehicles.put(vehicle, seatsAvailable);
                        seatsRequired -= seatsAvailable;
                    }
            }

        return reservedVehicles;
    }
}
