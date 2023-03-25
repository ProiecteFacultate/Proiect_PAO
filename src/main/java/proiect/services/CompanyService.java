package proiect.services;

import proiect.models.Vehicle;

import java.util.List;

public interface CompanyService {

    void addVehicle(Vehicle vehicle);
    void showVehicles();
    int getCompanyValue();
    int getCompanyIncomingEarnings();
    List<Vehicle> getEmptyVehicles();
    List<Vehicle> getFullVehicles();
}
