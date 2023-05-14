package proiect.models;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import proiect.models.abstracts.AbstractEntity;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;


@SuperBuilder
@Getter
public class Reservation extends AbstractEntity {
    private Integer totalPrice;


    public Reservation(Map<Vehicle, Integer> vehicles) {
        this.id = UUID.randomUUID();
        calculateTotalPrice(vehicles);
    }

    void calculateTotalPrice(Map<Vehicle, Integer> vehicles) {
        totalPrice = 0;
        Iterator<Map.Entry<Vehicle, Integer>> iterator = vehicles.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Vehicle, Integer> entry = iterator.next();
            Vehicle vehicle = entry.getKey();
            Integer numberOfSeats = entry.getValue();
            totalPrice += vehicle.getPrice() * numberOfSeats;
        }
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "totalPrice=" + totalPrice +
                '}';
    }
}
