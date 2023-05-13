package proiect.repository.impl;

import proiect.config.DatabaseConfiguration;
import proiect.mapper.ClientMapper;
import proiect.mapper.ReservationMapper;
import proiect.models.Client;
import proiect.models.Reservation;
import proiect.repository.ReservationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ReservationRepositoryImpl implements ReservationRepository {

    private static final ReservationMapper reservationMapper = ReservationMapper.getInstance();

    @Override
    public Optional<Reservation> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Reservation WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return reservationMapper.mapToReservation(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateReservationSql = "DELETE FROM Reservation WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateReservationSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Reservation newObject) {
        String updateReservationSql = "UPDATE Reservation \n" +
                                      "SET totalPrice=?, \n" +
                                      "WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateReservationSql)) {
            preparedStatement.setInt(1, newObject.getTotalPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Reservation reservation) {
        String insertSql = "INSERT INTO Reservation (id, totalPrice) VALUES (?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, reservation.getId().toString());
            preparedStatement.setInt(2, reservation.getTotalPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation> getAll() {
        String selectSql = "SELECT * FROM Reservation";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return reservationMapper.mapToReservationList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Reservation> reservationsList) {
        reservationsList.forEach(this::addNewObject);
    }
}
