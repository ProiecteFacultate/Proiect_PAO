package proiect.repository.impl;

import proiect.config.DatabaseConfiguration;
import proiect.mapper.Client_ReservationMapper;
import proiect.mapper.ReservationMapper;
import proiect.models.Client_Reservation;
import proiect.models.Reservation;
import proiect.repository.Client_ReservationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Client_ReservationRepositoryImpl implements Client_ReservationRepository {

    private static final Client_ReservationMapper clientReservationMapper = Client_ReservationMapper.getInstance();

    @Override
    public Optional<Client_Reservation> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Client_Reservation WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return clientReservationMapper.mapToClientReservation(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateClientReservationSql = "DELETE FROM Client_Reservation WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateClientReservationSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Client_Reservation newObject) {
        String updateClientReservationSql = "UPDATE Client_Reservation \n" +
                                            "SET client_id=?, \n" +
                                            "reservation_id=?, \n" +
                                            "WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateClientReservationSql)) {
            preparedStatement.setString(1, newObject.getClientId().toString());
            preparedStatement.setString(2, newObject.getReservationId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Client_Reservation clientReservation) {
        String insertSql = "INSERT INTO Client_Reservation (id, client_id, reservation_id) VALUES (?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, clientReservation.getId().toString());
            preparedStatement.setString(2, clientReservation.getClientId().toString());
            preparedStatement.setString(3, clientReservation.getReservationId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client_Reservation> getAll() {
        String selectSql = "SELECT * FROM Client_Reservation";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return clientReservationMapper.mapToClientReservationList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Client_Reservation> clientReservationList) {
        clientReservationList.forEach(this::addNewObject);
    }
}
