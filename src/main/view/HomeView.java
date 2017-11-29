package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;

    public void showResults(Request request)
    {
        role= (String)request.get("role");
    }


    public void showOptions()
    {

        switch(role)
        {
            case "user":
                System.out.println("Benvenuto user");
                System.out.println("-------MENU-------");
                System.out.println("");
                System.out.println("1) Visualizza brand gomma per tipologia veicolo");
                this.choice = Integer.parseInt(getInput());
                break;
            case "admin":
                System.out.println("Benvenuto Admin ContraderFramework");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU-------");
                System.out.println("");
                System.out.println("1) Inserisci gomma");
                System.out.println("2) Visualizza gomme disponibili");
                System.out.println("3) Logout");
                this.choice = Integer.parseInt(getInput());
        }

    }

    public void submit()
    {
        switch(role)
        {
            case "user":
            {
                if (choice < 1 || choice > 3)
                {
                    Request request = new Request();
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }
                else if (choice == 3)
                    MainDispatcher.getInstance().callAction("Login", "doControl", null);
                else {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                }
            }
            break;
            case "admin":
                if (choice < 1 || choice > 3)
                {
                    Request request = new Request();
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }
                else if (choice == 3)
                    MainDispatcher.getInstance().callAction("Login", "doControl", null);
                else {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                     }
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
