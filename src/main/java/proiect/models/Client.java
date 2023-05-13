package proiect.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Client {

    private UUID id;
    private final String firstName;
    private final String lastName;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void makeReservation(Reservation reservation) {

    }

    public int totalCost() {
        int total = 0;

        return total;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", totalCost=" + totalCost() +
                '}';
    }
}
