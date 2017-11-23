package main.controller;

import main.MainDispatcher;

import java.util.HashMap;
import java.util.Map;

public class HomeController implements Controller {

    public HomeController() {
    }

    public void doControl (Request request) {
        String nomeUtente = request.get("nomeUtente").toString();
        String password = request.get("password").toString();
        if(nomeUtente.equals("Pippo") && password.equals("Paperino"))
            MainDispatcher.getInstance().callView("Home", request);
        else
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
    }
}
