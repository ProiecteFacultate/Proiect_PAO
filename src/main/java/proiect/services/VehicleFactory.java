package proiect.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VehicleFactory {

    BufferedReader reader;
    String command;

    public VehicleFactory() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

  /*  public Vehicle getVehicle(String vehicleType) throws IOException{
        switch (vehicleType.toLowerCase()) {
            case "bus":
                return createBus();
            case "train":
                return createTrain();
            case "plane":
                return createPlane();
            case "helicopter":
                return createHelicopter();
            default:
                return null;
        }
    }

    private Vehicle createBus() throws IOException{
        Bus newVehicle = new Bus();
        defaultRequests(newVehicle);

        System.out.println("Introdu tipul de combustibil(PETROL/DIESEL/ELECTRIC): ");
        command = reader.readLine();

        if(command.equalsIgnoreCase("petrol"))
            newVehicle.setFuel(FuelEnum.PETROL);
        else if(command.equalsIgnoreCase("diesel"))
            newVehicle.setFuel(FuelEnum.DIESEL);
        else
            newVehicle.setFuel(FuelEnum.ELECTRIC);

        return newVehicle;
    }

    private Train createTrain() throws IOException{
        Train newVehicle = new Train();
        defaultRequests(newVehicle);

        System.out.println("Introdu numarul vagoanelor: ");
        command = reader.readLine();
        newVehicle.setNumberOfWagons(Integer.parseInt(command));

        return newVehicle;
    }

    private Plane createPlane() throws IOException{
        Plane newVehicle = new Plane();
        defaultRequests(newVehicle);

        System.out.println("Introdu altitudinea maxima: ");
        command = reader.readLine();
        newVehicle.setMaxAltitude(Integer.parseInt(command));

        return newVehicle;
    }

    private Helicopter createHelicopter() throws IOException{
        Helicopter newVehicle = new Helicopter();
        defaultRequests(newVehicle);

        System.out.println("Introdu tipul elicopterului (SMALL/MEDIUM/BIG): ");
        command = reader.readLine();

        if(command.equalsIgnoreCase("small"))
            newVehicle.setHelicopterType(HelicopterEnum.SMALL);
        else if(command.equalsIgnoreCase("medium"))
            newVehicle.setHelicopterType(HelicopterEnum.MEDIUM);
        else
            newVehicle.setHelicopterType(HelicopterEnum.BIG);

        return newVehicle;
    }

    private void defaultRequests(Vehicle newVehicle) throws IOException{
        System.out.println("Introdu capacitatea vehiculului: ");
        command = reader.readLine();
        newVehicle.setCapacity(Integer.parseInt(command));
        System.out.println("Introdu pretul unui bilet: ");
        command = reader.readLine();
        newVehicle.setPrice(Integer.parseInt(command));
    }   */
}
