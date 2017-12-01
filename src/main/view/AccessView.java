package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class AccessView implements View
{
    private String choiceLogin="";

    @Override
    public void showResults(Request request) {

    }

    @Override
    public void showOptions()
    {
        System.out.println("Welcome to ContraderFramework");
        System.out.println("****Menu****");
        System.out.println("Digita 1 per effettuare il login");
        System.out.println("Digita 2 per effettuare la registrazione");
        int sel=(Integer.parseInt(getInput()));
        if(sel==1)
            choiceLogin="login";
        else
            if(sel==2)
                choiceLogin="sigIn";
        else
                System.out.println("La scelta non consente operazioni");

    }

    @Override
    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit()
    {
        if(!choiceLogin.equals(""))
        {
            Request request = new Request();
            request.put("choiceLogin", choiceLogin);
            request.put("role",null);
            MainDispatcher.getInstance().callAction("User", "doControl", request);
        }
        else
        {
            MainDispatcher.getInstance().callAction("Access", "doControl", null);
        }
    }
}
