package main.controller;

import main.MainDispatcher;
import main.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class LoginController implements Controller {

    public LoginController() {
    }

    public void doControl (Request request) {
        MainDispatcher.getInstance().callView("Login", request);
    }
}
