package proiect.models;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import proiect.models.abstracts.AbstractEntity;
import java.util.UUID;

@SuperBuilder
@Getter
public class Client_Reservation extends AbstractEntity {
    private UUID clientId;
    private UUID reservationId;
}
