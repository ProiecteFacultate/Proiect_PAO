package proiect.models;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import proiect.models.abstracts.AbstractEntity;

@SuperBuilder
@Getter
public class Client extends AbstractEntity {
    private final String firstName;
    private final String lastName;

    public void makeReservation(Reservation reservation) {

    }

    public int totalCost() {
        int total = 0;

        return total;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", totalCost=" + totalCost() +
                '}';
    }
}
