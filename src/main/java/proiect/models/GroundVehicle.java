package proiect.models;

public abstract class GroundVehicle extends Vehicle {

    public GroundVehicle(){}
    protected GroundVehicle(Integer capacity, Integer price) {
        super(capacity, price);
    }
}
