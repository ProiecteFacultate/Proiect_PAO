package proiect.models;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import proiect.models.abstracts.AbstractEntity;


@SuperBuilder
@Getter
public class Reservation extends AbstractEntity {
    private Integer totalPrice;

    public Reservation() {
        calculateTotalPrice();
    }

    void calculateTotalPrice() {
        totalPrice = 0;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "totalPrice=" + totalPrice +
                '}';
    }
}
