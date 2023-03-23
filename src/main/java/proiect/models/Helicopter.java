package proiect.models;

public class Helicopter extends AerialVehicle{

    private boolean hasDoublePropeller;
    private boolean hasWheels;

    public Helicopter(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfEngines, boolean fliesHighAltitude, boolean hasDoublePropeller, boolean hasWheels) {
        super(capacity, maxSpeed, consumption, numberOfEngines, fliesHighAltitude);
        this.hasDoublePropeller = hasDoublePropeller;
        this.hasWheels = hasWheels;
    }

    @Override
    void presentConsumption() {
        System.out.println("This helicopter consumes " + consumption + " liters of diesel per hour");
    }

    @Override
    void drive() {
        System.out.println("Going straight in the air");
    }
}
