package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.services.GommaService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private String mode;

  public GommaView () {
      this.gommaService = new GommaService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this. mode  = (String) request.get("mode");
    }

    @Override
    public void showOptions() {
        switch (mode) {
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
                String model = scanner.next();
                System.out.println("Produttore:");
                String manufacturer = scanner.next();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(scanner.next());
                gommaService.insertGomma(new Gomma(model, manufacturer, price));
        }
    }

    @Override
    public void submit() {
//        MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }



}
