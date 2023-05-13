package proiect.models;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private Integer totalPrice;

    public Reservation() {
        calculateTotalPrice();
    }

    public Reservation(UUID id) {
        this.id = id;
        calculateTotalPrice();
    }


    void calculateTotalPrice() {
        totalPrice = 0;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "totalPrice=" + totalPrice +
                '}';
    }
}
