package proiect;

import proiect.models.Client;
import proiect.models.Reservation;
import proiect.models.Vehicle;
import proiect.services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Optional;

public class Menu {

    BufferedReader reader;
    CompanyService company;
    ClientsListingService clients;

    public Menu(CompanyService company, ClientsListingService clients) {
        this.company = company;
        this.clients = clients;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    void parseCommand(String command) throws IOException{
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
            case "adauga client":
                addClient();
                break;
            case "rezerva locuri":
                reserve();
                break;
            case "arata clienti":
                showClients();
            case "arata un client":
                showAClient();
                break;
            default:
                System.out.println("Comanda inexistenta");
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
        System.out.println("rezerva locuri");
        System.out.println("adauga client");
        System.out.println("arata clienti");
        System.out.println("arata un client");
        System.out.println();
    }

    void addVehicle() throws IOException{
        System.out.println("Introdu tipul de vehicul(BUS/TRAIN/PLANE/HELICOPTER): ");
        String command = reader.readLine();
        Vehicle vehicle = new VehicleFactory().getVehicle(command);
        if(vehicle == null)
            System.out.println("Ati introdus un tip de vehicul inexistent");
        else
            company.addVehicle(vehicle);
    }

    void showVehicles(){
        if(((Company) company).getVehicleList().size() == 0)
            System.out.println("Compania nu detine niciun vehicul");
        else {
            System.out.println("Compania detine urmatoarele vehicule:");
            company.showVehicles();
        }
    }

    void showCompanyValue() {
        System.out.println("Valoarea locurilor puse la vanzare de companie este de " + company.getCompanyValue() + " lei");
    }

    void showCompanyEarnings() {
        System.out.println("Valoarea totala a locurilor inchiriate este de " + company.getCompanyIncomingEarnings() + " lei");
    }

    void showFullVehicles() {
        if (company.getFullVehicles().size() == 0)
        {
            System.out.println("Nu esita vehicule inchiriate in totalitate!");
            return;
        }

        System.out.println("Vehiculele inchiriate in totalitate sunt:");
        for(Vehicle vehicle : company.getFullVehicles())
            System.out.println(vehicle);
    }

    void showEmptyVehicles() {
        if (company.getEmptyVehicles().size() == 0)
        {
            System.out.println("Nu esita vehicule libere!");
            return;
        }

        System.out.println("Vehiculele libere sunt:");
        for(Vehicle vehicle : company.getEmptyVehicles())
            System.out.println(vehicle);
    }

    void addClient() throws IOException{
        System.out.println("Introdu nume client:");
        String lastName = reader.readLine();
        System.out.println("Introdu prenume client:");
        String firstName = reader.readLine();
        clients.addClient(new Client(firstName, lastName));
    }

    void reserve() throws IOException {
        System.out.println("Introdu numele clientului care rezerva:");
        String lastName = reader.readLine();
        System.out.println("Introdu prenumele clientului care rezerva:");
        String firstName = reader.readLine();
        Optional<Client> clientForReservation = clients.getClient(firstName, lastName);

        if(clientForReservation.isPresent()) {
            System.out.println("Introdu tipul de vehicul (BUS/TRAIN/PLANE/HELICOPTER):");
            String vehicleType = reader.readLine();
            System.out.println("Introdu numarul de bilete:");
            int seatsRequired = Integer.parseInt(reader.readLine());

            Map<Vehicle, Integer> reservedVehicles = new HandleReservations().makeReservation(company, vehicleType, seatsRequired);
            if(!reservedVehicles.isEmpty()) {
                System.out.println("Rezervare reusita");
                clientForReservation.get().makeReservation(new Reservation(reservedVehicles));
            }
            else
                System.out.println("Tip de vehicul introdus gresit sau numar locuri insuficiente");
        } else
            System.out.println("Clientul nu exista");
    }

    void showClients() {
        if(((ClientsListing) clients).getClientsList().size() == 0)
            System.out.println("Nu exista clienti");
        else {
            System.out.println("Lista clientilor este:");
            clients.showClients();
        }
    }

    void showAClient () throws IOException{
        System.out.println("Introdu numele clientului:");
        String lastName = reader.readLine();
        System.out.println("Introdu prenumele clientului:");
        String firstName = reader.readLine();
        Optional<Client> client = clients.getClient(firstName, lastName);

        if(client.isPresent())
            System.out.println(client.get());
        else
            System.out.println("Clientul dat nu exista");
    }
}
