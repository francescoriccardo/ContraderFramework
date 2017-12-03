package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Vehicle;
import main.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class VehicleView implements View
{
    private VehicleService vehicleService;
    private String mode;
    private String role;
    private String firstname;
    private Integer idvehicle;
    private Integer choice;

    public VehicleView()
    {
        this.vehicleService = new VehicleService();
    }

    @Override
    public void showResults(Request request)
    {
        mode=(String)request.get("mode");
        role=(String)request.get("role");
        firstname=(String) request.get("firstname");
        choice=(Integer) request.get("choice");
    }

    @Override
    public void showOptions() {
        switch (mode)
        {
            case "allVehicle":
            {
                List<Vehicle> vehicles=vehicleService.getAllvehicle();
                System.out.println("----- Veicoli registrati -----");
                System.out.println();
                vehicles.forEach(vehicle -> System.out.println(vehicle));
            }break;
            case "insertVehicle":
            {
                String brand;
                String model;
                String fuel;
                String version;
                String capacity;
                System.out.println("Inserisci la marca");
                brand=getInput();
                System.out.println("Inserisci il modello");
                model=getInput();
                System.out.println("Inserisci l'alimentazione");
                fuel=getInput();
                System.out.println("Inserisci la versione");
                version=getInput();
                System.out.println("Inserisci la cilindrata");
                capacity=getInput();
                vehicleService.insertVehicle(new Vehicle(null,brand,model,fuel,version,capacity));
            }
            break;
            case "getIdVehicle":
            {
                String brand,model,fuel,version,capacity;
                System.out.println("Inserisci la marca");
                brand=getInput();
                System.out.println("Inserisci il modello");
                model=getInput();
                System.out.println("Inserisci l'alimentazione");
                fuel=getInput();
                System.out.println("Inserisci la versione");
                version=getInput();
                System.out.println("Inserisci la cilindrata");
                capacity=getInput();
                idvehicle=vehicleService.getIdVehicle(brand, model, fuel, version, capacity);
            }
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit()
    {
        switch (mode)
        {
            case "getIdVehicle":
            {
                if(idvehicle!=null)
                {
                    Request request = new Request();
                    request.put("role", role);
                    request.put("firstname",firstname);
                    request.put("idvehicle",idvehicle);
                    request.put("choice",choice);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl",request);
                }
                else
                {
                    System.out.println("Nessuna corrispondenza trovata");
                    Request request = new Request();
                    request.put("role", role);
                    request.put("firstname",firstname);
                    MainDispatcher.getInstance().callAction("Home", "doControl",request);
                }
            }
        }
        Request request = new Request();
        request.put("role", role);
        request.put("firstname",firstname);
        MainDispatcher.getInstance().callAction("Home", "doControl",request);
    }
}
