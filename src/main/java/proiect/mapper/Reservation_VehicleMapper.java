package proiect.mapper;

import proiect.models.Client_Reservation;
import proiect.models.Reservation_Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Reservation_VehicleMapper {

    private static final Reservation_VehicleMapper INSTANCE = new Reservation_VehicleMapper();

    private Reservation_VehicleMapper() {
    }

    public static Reservation_VehicleMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Reservation_Vehicle> mapToReservationVehicle(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Reservation_Vehicle.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .vehicleId(UUID.fromString(resultSet.getString(2)))
                            .reservationId(UUID.fromString(resultSet.getString(3)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Reservation_Vehicle> mapToReservationVehicleList(ResultSet resultSet) throws SQLException {
        List<Reservation_Vehicle> reservationVehiclesList = new ArrayList<>();
        while (resultSet.next()) {
            reservationVehiclesList.add(
                    Reservation_Vehicle.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .vehicleId(UUID.fromString(resultSet.getString(2)))
                            .reservationId(UUID.fromString(resultSet.getString(3)))
                            .build()
            );
        }

        return reservationVehiclesList;
    }
}
