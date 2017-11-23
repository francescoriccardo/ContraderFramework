package main.controller;

import main.MainDispatcher;
import main.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class LoginController implements Controller {

    public LoginController() {
    }

    public void doControl (Map<String, Object> data) {
        MainDispatcher.getInstance().callView("Login", data);
    }
}
