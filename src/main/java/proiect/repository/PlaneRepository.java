package proiect.repository;

import proiect.models.Plane;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlaneRepository {

    Optional<Plane> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Plane newObject);

    void addNewObject(Plane plane);

    List<Plane> getAll();

    void addAllFromGivenList(List<Plane> planeList);
}
