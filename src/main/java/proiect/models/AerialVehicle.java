package proiect.models;

public abstract class AerialVehicle extends Vehicle {

    protected Integer numberOfEngines;
    protected boolean fliesHighAltitude;

    public AerialVehicle(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfEngines, boolean fliesHighAltitude) {
        super(capacity, maxSpeed, consumption);
        this.numberOfEngines = numberOfEngines;
        this.fliesHighAltitude = fliesHighAltitude;
    }
}
