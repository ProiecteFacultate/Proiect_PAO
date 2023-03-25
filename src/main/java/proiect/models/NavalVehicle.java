package proiect.models;

public abstract class NavalVehicle extends Vehicle {

    protected Integer numberOfRooms;

    public NavalVehicle(){}

    public NavalVehicle(Integer capacity, Integer price, Integer numberOfRooms) {
        super(capacity, price);
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}