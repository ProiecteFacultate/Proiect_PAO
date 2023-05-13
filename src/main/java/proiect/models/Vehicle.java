package proiect.models;

import proiect.enums.VehicleType;

import java.util.UUID;

public class Vehicle {

    protected UUID id;
    protected Integer capacity;   //number of seats
    protected Integer numberOfReservedSeats = 0;
    protected Integer price;     //per seat
    protected VehicleType vehicleType;

    public Vehicle() {}
    public Vehicle(Integer capacity, Integer price) {
        this.capacity = capacity;
        this.price = price;
    }

    public Vehicle(UUID id, Integer capacity, Integer price) {
        this.id = id;
        this.capacity = capacity;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberOfReservedSeats() {
        return numberOfReservedSeats;
    }

    public void setNumberOfReservedSeats(Integer numberOfReservedSeats) {
        this.numberOfReservedSeats = numberOfReservedSeats;
    }
}
