package proiect.models;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private final String firstName;
    private final String lastName;
    private List<Reservation> reservationList = new ArrayList<>();

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void makeReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    public int totalCost() {
        int total = 0;

        for(Reservation reservation : reservationList)
            total += reservation.getTotalPrice();

        return total;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reservationList=" + reservationList + '\'' +
                ", totalCost=" + totalCost() +
                '}';
    }
}
