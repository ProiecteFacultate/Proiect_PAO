package proiect.repository;

import proiect.models.Bus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BusRepository {

    Optional<Bus> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Bus newObject);

    void addNewObject(Bus bus);

    List<Bus> getAll();

    void addAllFromGivenList(List<Bus> busesList);
}
