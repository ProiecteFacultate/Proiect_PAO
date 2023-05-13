package proiect.repository.impl;

import proiect.config.DatabaseConfiguration;
import proiect.mapper.VehicleMapper;
import proiect.models.Vehicle;
import proiect.repository.VehicleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VehicleRepositoryImpl implements VehicleRepository {

    private static final VehicleMapper vehicleMapper = VehicleMapper.getInstance();

    @Override
    public Optional<Vehicle> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Vehicle WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return vehicleMapper.mapToVehicle(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateVehicleSql = "DELETE FROM Vehicle WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateVehicleSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Vehicle newObject) {
        String updateVehicleSql = "UPDATE Vehicle \n" +
                                  "SET capacity=?, \n" +
                                  "numberOfReservedSeats=?, \n" +
                                  "price=?, \n" +
                                  "vehicleType=?\n" +
                                  "WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateVehicleSql)) {
            preparedStatement.setInt(1, newObject.getCapacity());
            preparedStatement.setInt(2, newObject.getNumberOfReservedSeats());
            preparedStatement.setInt(3, newObject.getPrice());
            preparedStatement.setString(4, newObject.getVehicleType().toString());
            preparedStatement.setString(5, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Vehicle vehicle) {
        String insertSql = "INSERT INTO Vehicle (id, capacity, numberOfReservedSeats, price, vehicleType) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, vehicle.getId().toString());
            preparedStatement.setInt(2, vehicle.getCapacity());
            preparedStatement.setInt(3, vehicle.getNumberOfReservedSeats());
            preparedStatement.setInt(4, vehicle.getPrice());
            preparedStatement.setString(5, vehicle.getVehicleType().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> getAll() {
        String selectSql = "SELECT * FROM Vehicle";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return vehicleMapper.mapToVehcileList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Vehicle> vehiclesList) {
        vehiclesList.forEach(this::addNewObject);
    }
}
