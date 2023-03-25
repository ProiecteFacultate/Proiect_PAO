package proiect.models;

public class SailBoat extends NavalVehicle{

    public SailBoat(){}

    public SailBoat(Integer capacity, Integer price, Integer numberOfRooms) {
        super(capacity, price, numberOfRooms);
    }

    @Override
    public String toString() {
        return "SailBoat{" +
                "numberOfRooms=" + numberOfRooms +
                ", capacity=" + capacity +
                ", numberOfReservedSeats=" + numberOfReservedSeats +
                ", price=" + price +
                '}';
    }
}