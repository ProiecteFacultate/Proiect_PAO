package proiect.models;

public class Train extends GroundVehicle {

    private Integer numberOfWagons;

    public Train() {}
    public Train(Integer capacity, Integer price, Integer numberOfWagons) {
        super(capacity, price);
        this.numberOfWagons = numberOfWagons;
    }

    public Integer getNumberOfWagons() {
        return numberOfWagons;
    }

    public void setNumberOfWagons(Integer numberOfWagons) {
        this.numberOfWagons = numberOfWagons;
    }

    @Override
    public String toString() {
        return "Train{" +
                "numberOfWagons=" + numberOfWagons +
                ", capacity=" + capacity +
                ", numberOfReservedSeats=" + numberOfReservedSeats +
                ", price=" + price +
                '}';
    }
}
