package proiect.models;

public class Yacht extends NavalVehicle{

    public Yacht(){}

    public Yacht(Integer capacity, Integer price, Integer numberOfRooms) {
        super(capacity, price, numberOfRooms);
    }

    @Override
    public String toString() {
        return "Yacht{" +
                "numberOfRooms=" + numberOfRooms +
                ", capacity=" + capacity +
                ", numberOfReservedSeats=" + numberOfReservedSeats +
                ", price=" + price +
                '}';
    }
}