package proiect;

import proiect.services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{

        CompanyService company = new Company();
        ClientsListingService clients = new ClientsListing();
        Menu menu = new Menu(company, clients);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      /*  menu.help();

        while (true) {
            System.out.println("Introdu o comanda");

            String command = reader.readLine();
            if(command.equalsIgnoreCase("exit"))
                break;
            else
                menu.parseCommand(command);
        }

        System.out.println("App ended");
          */
    }
}
