package proiect.repository;

import proiect.models.Helicopter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HelicopterRepository {

    Optional<Helicopter> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Helicopter newObject);

    void addNewObject(Helicopter helicopter);

    List<Helicopter> getAll();

    void addAllFromGivenList(List<Helicopter> helicoptersList);
}
