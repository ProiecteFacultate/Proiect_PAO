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
}
