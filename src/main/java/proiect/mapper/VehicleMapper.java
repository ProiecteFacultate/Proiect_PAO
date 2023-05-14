package proiect.mapper;

import proiect.enums.VehicleType;
import proiect.models.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VehicleMapper {

    private static final VehicleMapper INSTANCE = new VehicleMapper();

    private VehicleMapper() {
    }

    public static VehicleMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Vehicle> mapToVehicle(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Vehicle.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .capacity(resultSet.getInt(2))
                            .numberOfReservedSeats(resultSet.getInt(3))
                            .price(resultSet.getInt(4))
                            .vehicleType(VehicleType.valueOf(resultSet.getString(5)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Vehicle> mapToVehcileList(ResultSet resultSet) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<>();
        while (resultSet.next()) {
            vehicleList.add(
                    Vehicle.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .capacity(resultSet.getInt(2))
                            .numberOfReservedSeats(resultSet.getInt(3))
                            .price(resultSet.getInt(4))
                            .vehicleType(VehicleType.valueOf(resultSet.getString(5)))
                            .build()
            );
        }

        return vehicleList;
    }
}
