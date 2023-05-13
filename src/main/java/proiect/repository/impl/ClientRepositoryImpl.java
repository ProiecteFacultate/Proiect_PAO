package proiect.repository.impl;

import proiect.config.DatabaseConfiguration;
import proiect.mapper.ClientMapper;
import proiect.mapper.VehicleMapper;
import proiect.models.Client;
import proiect.models.Vehicle;
import proiect.repository.ClientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientRepositoryImpl implements ClientRepository {

    private static final ClientMapper clientMapper = ClientMapper.getInstance();

    @Override
    public Optional<Client> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Client WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return clientMapper.mapToClient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateClientSql = "DELETE FROM Client WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateClientSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Client newObject) {
        String updateClientSql = "UPDATE Client \n" +
                                  "SET firstName=?, \n" +
                                  "lastName=?, \n" +
                                  "WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateClientSql)) {
            preparedStatement.setString(1, newObject.getFirstName());
            preparedStatement.setString(2, newObject.getLastName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Client client) {
        String insertSql = "INSERT INTO Client (id, firstName, lastName) VALUES (?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, client.getId().toString());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getLastName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAll() {
        String selectSql = "SELECT * FROM Client";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return clientMapper.mapToClientList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Client> clientsList) {
        clientsList.forEach(this::addNewObject);
    }
}
