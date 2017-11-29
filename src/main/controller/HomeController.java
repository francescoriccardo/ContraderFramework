package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;
    private String role="";

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request)
    {
        if ((request != null)&&(role.equals("")))
        {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            role=loginService.login(nomeUtente, password);
            if (role!=null)
            {
                request.put("role",role);
                MainDispatcher.getInstance().callView("Home",request);
            }
            else
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
        else MainDispatcher.getInstance().callView("Home", request);

    }
}
