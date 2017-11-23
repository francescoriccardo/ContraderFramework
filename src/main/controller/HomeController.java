package main.controller;

import main.MainDispatcher;

import java.util.HashMap;
import java.util.Map;

public class HomeController implements Controller {

    public HomeController() {
    }

    public void doControl (Map<String, Object> data) {
        String nomeUtente = data.get("nomeUtente").toString();
        String password = data.get("password").toString();
        if(nomeUtente.equals("Pippo") && password.equals("Paperino"))
            MainDispatcher.getInstance().callView("Home", data);
        else
            MainDispatcher.getInstance().callAction("Login", "doControl", data);
    }
}
