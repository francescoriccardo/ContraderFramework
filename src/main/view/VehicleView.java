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

    public VehicleView()
    {
        this.vehicleService = new VehicleService();
    }

    @Override
    public void showResults(Request request)
    {
        mode=(String)request.get("mode");
        role=(String)request.get("role");
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
        Request request = new Request();
        request.put("role", role);
        MainDispatcher.getInstance().callAction("Home", "doControl",request);
    }
}
