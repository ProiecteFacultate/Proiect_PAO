package proiect.models;

public abstract class GroundVehicle extends Vehicle {

    protected Integer numberOfWheels;
    protected boolean isRailed;

    public GroundVehicle(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfWheels, boolean isRailed) {
        super(capacity, maxSpeed, consumption);
        this.numberOfWheels = numberOfWheels;
        this.isRailed = isRailed;
    }
}
