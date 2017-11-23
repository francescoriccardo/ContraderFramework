package main.view;

import main.MainDispatcher;
import main.controller.HomeController;
import main.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginView implements View {

    private String nomeUtente;
    private String password;

    public void showResults (Map<String, Object> data) {

    }


    public void showOptions () {
        System.out.println("-----LOGIN----");
        System.out.println("Nome utente:");
        nomeUtente = getInput();
        System.out.println("Password:");
        password = getInput();
    }

    public void submit() {
        Map<String, Object> data = new HashMap<>();
        data.put("nomeUtente", nomeUtente);
        data.put("password", password);
        MainDispatcher.getInstance().callAction("Home", "doControl", data);
    }


    protected String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    protected void send () {
        HomeController homeController = new HomeController();
    }


}
