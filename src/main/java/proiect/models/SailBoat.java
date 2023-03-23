package proiect.models;

import proiect.enums.FuelEnum;

public class SailBoat extends NavalVehicle{

    private Integer length;
    private FuelEnum fuel;

    public SailBoat(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfEngines, boolean gotSails, Integer length, FuelEnum fuel) {
        super(capacity, maxSpeed, consumption, numberOfEngines, gotSails);
        this.length = length;
        this.fuel = fuel;
    }

    @Override
    void presentConsumption() {
        switch (fuel) {
            case PETROL -> System.out.println("This sailboat consumes " + consumption + " liters of petrol per hour");
            case DIESEL -> System.out.println("This sailboat consumes " + consumption + " liters of diesel per hour");
            case GAS -> System.out.println("This sailboat consumes " + consumption + " liters of gas per hour");
            case ELECTRIC -> System.out.println("This sailboat consumes " + consumption + " mW of electricity per hour");
        }
    }

    @Override
    void drive() {
        System.out.println("Floating on the sea");
    }
}
