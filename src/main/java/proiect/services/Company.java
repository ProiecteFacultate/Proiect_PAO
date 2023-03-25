package proiect.services;

import proiect.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Company implements CompanyService{

    List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    @Override
    public void showVehicles() {
        for(Vehicle vehicle : vehicleList)
            System.out.println(vehicle);
    }

    @Override
    public int getCompanyValue() {
        int value = 0;

        for(Vehicle vehicle : vehicleList)
            value += vehicle.getCapacity() * vehicle.getPrice();

        return value;
    }

    @Override
    public int getCompanyIncomingEarnings() {
        int value = 0;

        for(Vehicle vehicle : vehicleList)
            value += vehicle.getNumberOfReservedSeats() * vehicle.getPrice();

        return value;
    }

    @Override
    public List<Vehicle> getEmptyVehicles() {
        List<Vehicle> emptyVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicleList)
            if(vehicle.getNumberOfReservedSeats() == 0)
                emptyVehicles.add(vehicle);

        return emptyVehicles;
    }

    @Override
    public List<Vehicle> getFullVehicles() {
        List<Vehicle> emptyVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicleList)
            if(vehicle.getNumberOfReservedSeats().equals(vehicle.getCapacity()))
                emptyVehicles.add(vehicle);

        return emptyVehicles;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
