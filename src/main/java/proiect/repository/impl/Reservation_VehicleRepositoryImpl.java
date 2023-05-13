package proiect.repository.impl;

import proiect.config.DatabaseConfiguration;
import proiect.mapper.Client_ReservationMapper;
import proiect.mapper.Reservation_VehicleMapper;
import proiect.models.Client_Reservation;
import proiect.models.Reservation;
import proiect.models.Reservation_Vehicle;
import proiect.repository.ReservationRepository;
import proiect.repository.Reservation_VehicleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Reservation_VehicleRepositoryImpl implements Reservation_VehicleRepository {

    private static final Reservation_VehicleMapper reservationVehicleMapper = Reservation_VehicleMapper.getInstance();

    @Override
    public Optional<Reservation_Vehicle> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Reservation_Vehicle WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

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

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateReservationVehicleSql)) {
            preparedStatement.setString(1, id.toString());

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
                                            "WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateClientReservationSql)) {
            preparedStatement.setString(1, newObject.getVehicleId().toString());
            preparedStatement.setString(2, newObject.getReservationId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Reservation_Vehicle reservationVehicle) {
        String insertSql = "INSERT INTO Client_Reservation (id, vehicle_id, reservation_id) VALUES (?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, reservationVehicle.getId().toString());
            preparedStatement.setString(2, reservationVehicle.getVehicleId().toString());
            preparedStatement.setString(3, reservationVehicle.getReservationId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation_Vehicle> getAll() {
        String selectSql = "SELECT * FROM Reservation_Vehicle";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

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
