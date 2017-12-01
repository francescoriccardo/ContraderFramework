package main.view;

import main.MainDispatcher;
import main.controller.Request;
import org.springframework.scheduling.support.SimpleTriggerContext;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;
    private String firstname;

    public void showResults(Request request)
    {
        role= (String)request.get("role");
        firstname=(String) request.get("firstname");
    }


    public void showOptions()
    {

        switch(role)
        {
            case "user":
                System.out.println("Benvenuto "+firstname);
                System.out.println("-------MENU-------");
                System.out.println("");
                System.out.println("1) Cerca brand gomma per tipologia veicolo");
                System.out.println("2) Cerca gomme per dimensioni");
                System.out.println("3) Cerca brand gomma per il tuo veicolo");
                System.out.println("4) Logout");
                this.choice = Integer.parseInt(getInput());
                break;
            case "admin":
                System.out.println("Benvenuto Admin "+firstname+" ContraderFramework");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU-------");
                System.out.println("");
                System.out.println("1) Inserisci gomma");
                System.out.println("2) Visualizza gomme disponibili");
                System.out.println("3) Visualizza utenti registrati");
                System.out.println("4) Logout");
                this.choice = Integer.parseInt(getInput());
        }

    }

    public void submit()
    {
        switch(role)
        {
            case "user":
            {
                if (choice < 1 || choice > 4)
                {
                    Request request = new Request();
                    request.put("role", role);
                    request.put("firstname", firstname);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }
                else
                    if (choice == 4)
                    MainDispatcher.getInstance().callAction("Login", "doControl", null);
                    else
                    {
                        Request request = new Request();
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("firstname", firstname);
                        MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                     }
            }
            break;
            case "admin":
                if (choice < 1 || choice > 4)
                {
                    Request request = new Request();
                    request.put("role", role);
                    request.put("firstname", firstname);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }
                else
                    if (choice == 4)
                     MainDispatcher.getInstance().callAction("Login", "doControl", null);
                else
                    if(choice==3)
                    {
                        Request request = new Request();
                        request.put("role", role);
                        request.put("choiceLogin",null);
                        request.put("choice",choice);
                        request.put("firstname", firstname);
                        MainDispatcher.getInstance().callAction("User", "doControl", request);
                    }
                    else
                    {
                      Request request = new Request();
                      request.put("choice", choice);
                      request.put("role", role);
                      request.put("firstname", firstname);
                      MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                    }
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
