package main.controller;

import main.MainDispatcher;
import main.services.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        String nomeUtente = request.get("nomeUtente").toString();
        String password = request.get("password").toString();
        if (loginService.login(nomeUtente, password))
            MainDispatcher.getInstance().callView("Home", request);
        else
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
    }
}
