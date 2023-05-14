package proiect.services;

import proiect.enums.VehicleType;
import proiect.exceptions.MyException;
import proiect.models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class VehicleFactory {

    public static Vehicle getVehicle() throws IOException, MyException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        VehicleType vehicleType;

        System.out.println("Introdu tipul de vehicul(BUS/TRAIN/PLANE/HELICOPTER): ");
        try {
            vehicleType = VehicleType.valueOf(reader.readLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new MyException("Tip vehicul inexistent");
        }

        System.out.println("Introdu capacitatea vehiculului: ");
        int capacity = Integer.parseInt(reader.readLine());

        System.out.println("Introdu pretul unui bilet: ");
        int price = Integer.parseInt(reader.readLine());

        return new Vehicle(capacity, price, vehicleType);
    }
}
