package proiect.models;

import proiect.enums.FuelEnum;

public class Car extends GroundVehicle{

    private boolean isSelfDriving;
    private FuelEnum fuel;

    public Car(Integer capacity, Integer maxSpeed, Integer consumption, Integer numberOfWheels, boolean isRailed, boolean isSelfDriving, FuelEnum fuel) {
        super(capacity, maxSpeed, consumption, numberOfWheels, isRailed);
        this.isSelfDriving = isSelfDriving;
        this.fuel = fuel;
    }

    @Override
    void presentConsumption() {
        switch (fuel) {
            case PETROL -> System.out.println("This car consumes " + consumption + " liters of petrol per 100 km");
            case DIESEL -> System.out.println("This car consumes " + consumption + " liters of diesel per 100 km");
            case GAS -> System.out.println("This car consumes " + consumption + " liters of gas per 100 km");
            case ELECTRIC -> System.out.println("This car consumes " + consumption + " mW of electricity per 100 km");
        }
    }

    @Override
    void drive() {
        System.out.println("Driving on the highway to hell");
    }
}
