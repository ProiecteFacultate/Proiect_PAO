package proiect.models;

import java.util.Map;

public class Reservation {

    private Integer totalPrice;
    private Map<Vehicle, Integer> vehicles;     //vehicle -> number of seats

    public Reservation(Map<Vehicle, Integer> vehicles) {
        this.vehicles = vehicles;
        calculateTotalPrice();
    }

    void calculateTotalPrice() {
        totalPrice = 0;

        for(Map.Entry<Vehicle, Integer> entry : vehicles.entrySet())
            totalPrice += entry.getValue() * entry.getKey().getPrice();
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Vehicle, Integer> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<Vehicle, Integer> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "totalPrice=" + totalPrice +
                '}';
    }
}
