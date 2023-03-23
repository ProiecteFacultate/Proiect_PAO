package proiect.models;

public abstract class Vehicle {

    protected Integer capacity;   //number of people
    protected Integer maxSpeed;
    protected Integer consumption;

    public Vehicle(Integer capacity, Integer maxSpeed, Integer consumption) {
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.consumption = consumption;
    }

    void resize(Integer newCapacity) {
        capacity = newCapacity;
    }

    abstract void presentConsumption();

    abstract void drive();
}
