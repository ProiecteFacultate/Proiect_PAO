package proiect.models;

public abstract class NavalVehicle extends Vehicle {

    protected Integer numberOfEngines;

    public NavalVehicle(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfEngines, boolean gotSails) {
        super(capacity, maxSpeed, consumption);
        this.numberOfEngines = numberOfEngines;
        this.gotSails = gotSails;
    }

    protected boolean gotSails;
}
