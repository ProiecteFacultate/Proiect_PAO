package proiect.models;

import proiect.enums.FuelEnum;

public class Bus extends GroundVehicle{

    private FuelEnum fuel;

    public Bus(){}

    public Bus(Integer capacity, Integer price, FuelEnum fuel) {
        super(capacity, price);
        this.fuel = fuel;
    }

    public FuelEnum getFuel() {
        return fuel;
    }

    public void setFuel(FuelEnum fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "fuel=" + fuel +
                ", capacity=" + capacity +
                ", numberOfReservedSeats=" + numberOfReservedSeats +
                ", price=" + price +
                '}';
    }
}
