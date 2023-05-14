package proiect.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import proiect.models.abstracts.AbstractEntity;
import proiect.repository.Reservation_VehicleRepository;
import proiect.repository.impl.*;
import proiect.services.ClientService;
import proiect.services.Client_ReservationService;
import proiect.services.Reservation_VehicleService;
import proiect.services.VehicleService;
import proiect.services.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SuperBuilder
@Getter
public class Client extends AbstractEntity {
    private final String firstName;
    private final String lastName;

    public Client(String firstName, String lastName) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int totalCost() {
        Client_ReservationService clientReservationService = new Client_ReservationServiceImpl(new Client_ReservationRepositoryImpl());
        ReservationServiceImpl reservationService = new ReservationServiceImpl(new ReservationRepositoryImpl());
        List<UUID> reservations = clientReservationService.getAllReservationsByClient(id);
        int total = 0;

        for (UUID reservationId : reservations)
            total += reservationService.getById(reservationId).get().getTotalPrice();

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
