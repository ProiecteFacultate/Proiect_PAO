package proiect.models;

public class Plane extends AerialVehicle{

    private Integer maxAltitude;

    public Plane(){}

    public Plane(Integer capacity, Integer price, Integer maxAltitude) {
        super(capacity, price);
        this.maxAltitude = maxAltitude;
    }

    public Integer isMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(Integer maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "maxAltitude=" + maxAltitude +
                ", capacity=" + capacity +
                ", numberOfReservedSeats=" + numberOfReservedSeats +
                ", price=" + price +
                '}';
    }
}
