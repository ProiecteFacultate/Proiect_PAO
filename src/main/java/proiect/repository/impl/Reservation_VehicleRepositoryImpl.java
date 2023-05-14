package proiect.repository.impl;

import proiect.config.DatabaseConfiguration;
import proiect.mapper.Client_ReservationMapper;
import proiect.mapper.Reservation_VehicleMapper;
import proiect.models.Client_Reservation;
import proiect.models.Reservation;
import proiect.models.Reservation_Vehicle;
import proiect.models.Vehicle;
import proiect.repository.ReservationRepository;
import proiect.repository.Reservation_VehicleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Reservation_VehicleRepositoryImpl implements Reservation_VehicleRepository {

    private static final Reservation_VehicleMapper reservationVehicleMapper = Reservation_VehicleMapper.getInstance();

    @Override
    public Optional<Reservation_Vehicle> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Reservation_Vehicle WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return reservationVehicleMapper.mapToReservationVehicle(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateReservationVehicleSql = "DELETE FROM Reservation_Vehicle WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateReservationVehicleSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Reservation_Vehicle newObject) {
        String updateClientReservationSql = "UPDATE Reservation_Vehicle \n" +
                                            "SET vehicle_id=?, \n" +
                                            "reservation_id=?, \n" +
                                            "seats_number=?, \n" +
                                            "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateClientReservationSql);
            preparedStatement.setObject(1, newObject.getVehicleId());
            preparedStatement.setObject(2, newObject.getReservationId());
            preparedStatement.setObject(2, newObject.getSeats_number());
            preparedStatement.setObject(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Reservation_Vehicle reservationVehicle) {
        String insertSql = "INSERT INTO Reservation_Vehicle (id, vehicle_id, reservation_id, seats_number) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, reservationVehicle.getId());
            preparedStatement.setObject(2, reservationVehicle.getVehicleId());
            preparedStatement.setObject(3, reservationVehicle.getReservationId());
            preparedStatement.setObject(4, reservationVehicle.getSeats_number());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation_Vehicle> getAll() {
        String selectSql = "SELECT * FROM Reservation_Vehicle";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return reservationVehicleMapper.mapToReservationVehicleList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Reservation_Vehicle> reservationVehicleList) {
        reservationVehicleList.forEach(this::addNewObject);
    }
}
