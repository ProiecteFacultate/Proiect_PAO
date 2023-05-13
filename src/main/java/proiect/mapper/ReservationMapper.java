package proiect.mapper;

import proiect.models.Client;
import proiect.models.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ReservationMapper {

    private static final ReservationMapper INSTANCE = new ReservationMapper();

    private ReservationMapper() {
    }

    public static ReservationMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Reservation> mapToReservation(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Reservation.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .totalPrice(resultSet.getInt(2))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Reservation> mapToReservationList(ResultSet resultSet) throws SQLException {
        List<Reservation> reservationList = new ArrayList<>();
        while (resultSet.next()) {
            reservationList.add(
                    Reservation.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .totalPrice(resultSet.getInt(2))
                            .build()
            );
        }

        return reservationList;
    }
}
