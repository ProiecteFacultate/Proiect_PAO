package proiect.models;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import proiect.enums.VehicleType;
import proiect.models.abstracts.AbstractEntity;

@SuperBuilder
@Getter
public class Vehicle extends AbstractEntity {
    protected Integer capacity;   //number of seats
    protected Integer numberOfReservedSeats = 0;
    protected Integer price;     //per seat
    protected VehicleType vehicleType;

    public Vehicle() {}
    public Vehicle(Integer capacity, Integer price) {
        this.capacity = capacity;
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberOfReservedSeats() {
        return numberOfReservedSeats;
    }

    public void setNumberOfReservedSeats(Integer numberOfReservedSeats) {
        this.numberOfReservedSeats = numberOfReservedSeats;
    }
}
