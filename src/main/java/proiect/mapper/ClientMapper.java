package proiect.mapper;

import proiect.enums.VehicleType;
import proiect.models.Client;
import proiect.models.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientMapper {

    private static final ClientMapper INSTANCE = new ClientMapper();

    private ClientMapper() {
    }

    public static ClientMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Client> mapToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Client.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .firstName(resultSet.getString(2))
                            .lastName(resultSet.getString(3))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Client> mapToClientList(ResultSet resultSet) throws SQLException {
        List<Client> clientList = new ArrayList<>();
        while (resultSet.next()) {
            clientList.add(
                    Client.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .firstName(resultSet.getString(2))
                            .lastName(resultSet.getString(3))
                            .build()
            );
        }

        return clientList;
    }
}
