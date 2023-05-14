package proiect.mapper;

import proiect.models.Client_Reservation;
import proiect.models.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Client_ReservationMapper {

    private static final Client_ReservationMapper INSTANCE = new Client_ReservationMapper();

    private Client_ReservationMapper() {
    }

    public static Client_ReservationMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Client_Reservation> mapToClientReservation(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Client_Reservation.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .clientId(UUID.fromString(resultSet.getString(2)))
                            .reservationId(UUID.fromString(resultSet.getString(3)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Client_Reservation> mapToClientReservationList(ResultSet resultSet) throws SQLException {
        List<Client_Reservation> clientReservationList = new ArrayList<>();
        while (resultSet.next()) {
            clientReservationList.add(
                    Client_Reservation.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .clientId(UUID.fromString(resultSet.getString(2)))
                            .reservationId(UUID.fromString(resultSet.getString(3)))
                            .build()
            );
        }

        return clientReservationList;
    }
}
