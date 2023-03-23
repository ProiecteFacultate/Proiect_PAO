package proiect.models;

public class Yacht extends NavalVehicle{

    private Integer numberOfRooms;
    private boolean hasHeliport;

    public Yacht(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfEngines, boolean gotSails, Integer numberOfRooms, boolean hasHeliport) {
        super(capacity, maxSpeed, consumption, numberOfEngines, gotSails);
        this.numberOfRooms = numberOfRooms;
        this.hasHeliport = hasHeliport;
    }

    @Override
    void presentConsumption() {
        System.out.println("This yacht consumes " + consumption + " liters of diesel per hour");
    }

    @Override
    void drive() {
        System.out.println("Conquering the oceans");
    }
}
