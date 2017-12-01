package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.dao.GommaDAO;
import main.service.GommaService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private String mode;
    private String role;
    private String firstname;

  public GommaView () {
      this.gommaService = new GommaService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request)
    {
       this.mode  = (String) request.get("mode");
       role=(String)request.get("role");
       firstname=(String)request.get("firstname");

    }

    @Override
    public void showOptions()
    {
        switch (mode)
        {
            case "all":
                List<Gomma> gomme = gommaService.getAllGomme();
                System.out.println("----- Gomme disponibili -----");
                System.out.println();
                gomme.forEach(gomma -> System.out.println(gomma));
            break;
            case "insert":
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Inserisci i dati della nuova gomma:");
                    System.out.println("Modello:");
                    String model = getInput();
                    System.out.println("Produttore:");
                    String manufacturer = getInput();
                    System.out.println("Prezzo:");
                    double price = Double.parseDouble(getInput());
                    System.out.println("Larghezza:");
                    double width = Double.parseDouble(getInput());
                    System.out.println("Altezza:");
                    double height = Double.parseDouble(getInput());
                    System.out.println("Diametro:");
                    double diameter = Double.parseDouble(getInput());
                    System.out.println("Carico:");
                    double weight = Double.parseDouble(getInput());
                    System.out.println("Velocita:");
                    String speed = getInput();
                    System.out.println("Stagioni:");
                    String season = getInput();
                    System.out.println("Tipo di veicolo:");
                    String typeVehicle = getInput();
                    System.out.println("Quantità:");
                    int quantity = Integer.parseInt(getInput());
                    gommaService.insertGomma(new Gomma(null, model, manufacturer, price, width, height, diameter, weight, speed, season, typeVehicle,quantity));
                    break;
            case "allBrandForVehicle":
                System.out.println("Inserisci il tipo di veicolo:(auto|moto|commerciale)");
                String type=getInput();
                List<String> brands = gommaService.getAllManufacturerForTypeVehicle(type);
                if(!brands.isEmpty())
                {
                    brands.forEach(brand-> System.out.println(brand));
                    System.out.println("----- Brand gomme disponibili -----");
                    brands.forEach(String -> System.out.println(String));
                    System.out.println("Scegli il brand");
                    String brand=getInput();
                    List<Gomma> gommes=gommaService.getAllGommeForManufacturer(brand,type);
                    if(!gommes.isEmpty())
                        gommes.forEach(gomma-> System.out.println(gomma));
                    else
                        System.out.println("Non ci sono gomme per il brand indicato");
                }
                else
                    System.out.println("Non ci sono veicoli per il tipo indicato");
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
        request.put("firstname", firstname);
        MainDispatcher.getInstance().callAction("Home", "doControl",request);
    }



}
