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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Client_ReservationRepositoryImpl implements Client_ReservationRepository {

    private static final Client_ReservationMapper clientReservationMapper = Client_ReservationMapper.getInstance();

    @Override
    public Optional<Client_Reservation> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Client_Reservation WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

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

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateClientReservationSql);
            preparedStatement.setObject(1, id);

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

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateClientReservationSql);
            preparedStatement.setObject(1, newObject.getClientId());
            preparedStatement.setObject(2, newObject.getReservationId());
            preparedStatement.setObject(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Client_Reservation clientReservation) {
        String insertSql = "INSERT INTO Client_Reservation (id, client_id, reservation_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, clientReservation.getId());
            preparedStatement.setObject(2, clientReservation.getClientId());
            preparedStatement.setObject(3, clientReservation.getReservationId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client_Reservation> getAll() {
        String selectSql = "SELECT * FROM Client_Reservation";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
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

    @Override
    public List<UUID> findAllReservationsByClient(UUID clientId) {
        String selectSql = "SELECT * FROM Client_Reservation WHERE client_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, clientId);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Client_Reservation> clientReservationList = clientReservationMapper.mapToClientReservationList(resultSet);
            List<UUID> reservationsIds = new ArrayList<>();
            for (Client_Reservation clientReservation : clientReservationList)
                reservationsIds.add(clientReservation.getReservationId());
            return reservationsIds;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }
}
