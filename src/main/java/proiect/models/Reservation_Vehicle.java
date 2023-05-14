package proiect.models;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import proiect.models.abstracts.AbstractEntity;
import java.util.UUID;

@SuperBuilder
@Getter
public class Reservation_Vehicle extends AbstractEntity {
    private UUID vehicleId;
    private UUID reservationId;
    private Integer seats_number;

    public Reservation_Vehicle(UUID vehicleId, UUID reservationId,Integer seats_number) {
        this.id = UUID.randomUUID();
        this.vehicleId = vehicleId;
        this.reservationId = reservationId;
        this.seats_number = seats_number;
    }
}
