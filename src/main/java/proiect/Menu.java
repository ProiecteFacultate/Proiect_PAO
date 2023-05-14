package proiect;

import proiect.csv.CsvWriter;
import proiect.enums.VehicleType;
import proiect.exceptions.MyException;
import proiect.models.*;
import proiect.repository.impl.*;
import proiect.services.*;
import proiect.services.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {

    BufferedReader reader;
    Logger logger = Logger.getLogger(Menu.class.getName());
    static final CsvWriter CSV_WRITER = CsvWriter.getInstance();
    VehicleService vehicleService;
    ClientService clientService;
    ReservationService reservationService;
    Reservation_VehicleService reservationVehicleService;
    Client_ReservationService clientReservationService;
    static Menu INSTANCE;

    public static Menu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Menu();
        }

        return INSTANCE;
    }
    public Menu() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        vehicleService = new VehicleServiceImpl(new VehicleRepositoryImpl());
        clientService = new ClientServiceImpl(new ClientRepositoryImpl());
        reservationService = new ReservationServiceImpl(new ReservationRepositoryImpl());
        reservationVehicleService = new Reservation_VehicleServiceImpl(new Reservation_VehicleRepositoryImpl());
        clientReservationService = new Client_ReservationServiceImpl(new Client_ReservationRepositoryImpl());
    }

    void parseCommand(String command) throws IOException{
        String[] line = new String[] { command, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss"))};
        List<String[]> lines = new ArrayList<>();
        lines.add(line);
        try {
            CSV_WRITER.writeLines(lines);
        } catch (Exception e) {

        }

        switch (command.toLowerCase()) {
            case "help":
                help();
                break;
            case "adauga vehicul":
                addVehicle();
                break;
            case "arata vehicule":
                showVehicles();
                break;
            case "arata valoarea companiei":
                showCompanyValue();
                break;
            case "arata castiguri urmatoare":
                showCompanyEarnings();
                break;
            case "arata vehiculele complet inchiriate":
                showFullVehicles();
                break;
            case "arata vehiculele libere":
                showEmptyVehicles();
                break;
            case "adauga client":
                addClient();
                break;
            case "arata clienti":
                showClients();
                break;
            case "arata un client":
                showClientByName();
                break;
            case "rezerva locuri":
                reserve();
                break;
            default:
                logger.log(Level.WARNING, "Comanda inexistenta");
                break;
        }
    }

    public void help() {
        System.out.println("Comenzi disponibile: ");
        System.out.println("help");
        System.out.println("adauga vehicul");
        System.out.println("arata vehicule");
        System.out.println("arata valoarea companiei");
        System.out.println("arata castiguri urmatoare");
        System.out.println("arata vehiculele complet inchiriate");
        System.out.println("arata vehiculele libere");
        System.out.println("adauga client");
        System.out.println("arata clienti");
        System.out.println("arata un client");
        System.out.println("rezerva locuri");
        System.out.println();
    }

    void addVehicle() throws IOException{
        try {
            Vehicle vehicle = VehicleFactory.getVehicle();
            vehicleService.addOnlyOne(vehicle);
        } catch (MyException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    void showVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllFromList();

        if(vehicles.isEmpty())
            System.out.println("Compania nu detine niciun vehicul");
        else {
            System.out.println("Compania detine urmatoarele vehicule:");
            for (Vehicle vehicle : vehicles)
                System.out.println(vehicle.toString());
        }
    }

    void showCompanyValue() {
        System.out.println("Valoarea locurilor puse la vanzare de companie este de " + vehicleService.getSoldSeatsValue() + " lei");
    }

    void showCompanyEarnings() {
        System.out.println("Valoarea totala a locurilor inchiriate este de " + vehicleService.getCompanyIncomingEarnings() + " lei");
    }

    void showFullVehicles() {
        List<Vehicle> fullVehicles = vehicleService.getFullVehicles();

        if (fullVehicles.isEmpty()) {
            System.out.println("Nu esita vehicule inchiriate in totalitate!");
            return;
        }

        System.out.println("Vehiculele inchiriate in totalitate sunt:");
        for(Vehicle vehicle : fullVehicles)
            System.out.println(vehicle);
    }

    void showEmptyVehicles() {
        List<Vehicle> emptyVehicles = vehicleService.getEmptyVehicles();

        if (emptyVehicles.isEmpty()) {
            System.out.println("Nu esita vehicule libere!");
            return;
        }

        System.out.println("Vehiculele libere sunt:");
        for(Vehicle vehicle : vehicleService.getEmptyVehicles())
            System.out.println(vehicle);
    }

    void addClient() throws IOException{
        System.out.println("Introdu nume client:");
        String lastName = reader.readLine();

        System.out.println("Introdu prenume client:");
        String firstName = reader.readLine();

        clientService.addOnlyOne(new Client(firstName, lastName));
    }

    void showClients() {
        List<Client> clients = clientService.getAllFromList();

        if(clients.isEmpty())
            System.out.println("Nu exista clienti");
        else {
            System.out.println("Lista clientilor este:");
            clientService.showAllClients();
        }
    }

    void showClientByName () throws IOException{
        System.out.println("Introdu numele clientului:");
        String lastName = reader.readLine();

        System.out.println("Introdu prenumele clientului:");
        String firstName = reader.readLine();

        Optional<Client> client = clientService.getByFirstNameAndLastName(firstName, lastName);

        if(client.isPresent())
            System.out.println(client.get());
        else
            System.out.println("Clientul dat nu exista");
    }

    void reserve() throws IOException {
        System.out.println("Introdu numele clientului care rezerva:");
        String lastName = reader.readLine();

        System.out.println("Introdu prenumele clientului care rezerva:");
        String firstName = reader.readLine();

        Optional<Client> clientForReservation = clientService.getByFirstNameAndLastName(firstName, lastName);
        if(clientForReservation.isEmpty()) {
            logger.log(Level.WARNING, "Clientul nu exista");
            return;
        }

        System.out.println("Introdu tipul de vehicul (BUS/TRAIN/PLANE/HELICOPTER):");
        VehicleType vehicleType;
        try {
            vehicleType = VehicleType.valueOf(reader.readLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Tip vehicul inexistent");
            return;
        }

        System.out.println("Introdu numarul de bilete:");
        int seatsRequired = Integer.parseInt(reader.readLine());

        Map<Vehicle, Integer> reservedVehicles = reservationService.makeReservation(vehicleType, seatsRequired, vehicleService.getAllFromList());

        if (reservedVehicles.isEmpty()) {
            logger.log(Level.WARNING, "Numar de locuri insuficiente");
            return;
        }

        Reservation reservation = new Reservation(reservedVehicles);
        reservationService.addOnlyOne(reservation);
        clientReservationService.addOnlyOne(new Client_Reservation(clientForReservation.get().getId(), reservation.getId()));

        Iterator<Map.Entry<Vehicle, Integer>> iterator = reservedVehicles.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Vehicle, Integer> entry = iterator.next();
            Vehicle vehicle = entry.getKey();
            Integer numberOfSeats = entry.getValue();
            vehicleService.reserveSeats(vehicle.getId(), numberOfSeats);

            reservationVehicleService.addOnlyOne(new Reservation_Vehicle(vehicle.getId(), reservation.getId(), numberOfSeats));
        }
    }
}
