package proiect.repository;

import proiect.models.Train;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrainRepository {

    Optional<Train> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Train newObject);

    void addNewObject(Train train);

    List<Train> getAll();

    void addAllFromGivenList(List<Train> trainsList);
}
