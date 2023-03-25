package proiect.models;

import proiect.enums.HelicopterEnum;

public class Helicopter extends AerialVehicle{

    private HelicopterEnum helicopterType;

    public Helicopter(){}
    public Helicopter(Integer capacity, Integer price, HelicopterEnum helicopterType) {
        super(capacity, price);
        this.helicopterType = helicopterType;
    }

    public HelicopterEnum getHelicopterType() {
        return helicopterType;
    }

    public void setHelicopterType(HelicopterEnum helicopterType) {
        this.helicopterType = helicopterType;
    }

    @Override
    public String toString() {
        return "Helicopter{" +
                "helicopterType=" + helicopterType +
                ", capacity=" + capacity +
                ", numberOfReservedSeats=" + numberOfReservedSeats +
                ", price=" + price +
                '}';
    }
}
