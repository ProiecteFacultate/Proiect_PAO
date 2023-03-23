package proiect.models;

public class Plane extends AerialVehicle{

    private Integer numberOfWings;
    private boolean hasJetEngines;

    public Plane(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfEngines, boolean fliesHighAltitude, Integer numberOfWings, boolean hasJetEngines) {
        super(capacity, maxSpeed, consumption, numberOfEngines, fliesHighAltitude);
        this.numberOfWings = numberOfWings;
        this.hasJetEngines = hasJetEngines;
    }

    @Override
    void presentConsumption() {
        System.out.println("This plane consumes " + consumption + " liters of diesel per hour");
    }

    @Override
    void drive() {
        System.out.println("Flying like a bird");
    }
}
