package proiect.models;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import proiect.enums.VehicleType;
import proiect.models.abstracts.AbstractEntity;

import java.util.UUID;

@SuperBuilder
@Getter
@Setter
public class Vehicle extends AbstractEntity {
    protected Integer capacity;   //number of seats
    protected Integer numberOfReservedSeats;
    protected Integer price;     //per seat
    protected VehicleType vehicleType;

    public Vehicle() {}

    public Vehicle(Integer capacity, Integer price, VehicleType vehicleType) {
        this.id = UUID.randomUUID();
        this.capacity = capacity;
        this.price = price;
        this.vehicleType = vehicleType;
        numberOfReservedSeats = 0;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "capacity=" + capacity +
                ", numberOfReservedSeats=" + numberOfReservedSeats +
                ", price=" + price +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
