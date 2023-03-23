package proiect.models;

public class Tram extends GroundVehicle {

    private Integer length;
    private boolean isDoubleEnded;

    public Tram(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfWheels, boolean isRailed, Integer length, boolean isDoubleEnded) {
        super(capacity, maxSpeed, consumption, numberOfWheels, isRailed);
        this.length = length;
        this.isDoubleEnded = isDoubleEnded;
    }

    @Override
    void presentConsumption() {
        System.out.println("This tram consumes " + consumption + " mW of electricity per 100 km");
    }

    @Override
    void drive() {
        System.out.println("Driving on the rails");
    }
}
