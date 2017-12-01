package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;
    private String result="";

    public HomeController()
    {
        loginService = new LoginService();
    }

    public void doControl(Request request)
    {
        if ((request != null)&&(request.get("role")== null)&&(request.get("firstname")==null))
        {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            result=loginService.login(nomeUtente, password);
            if (result!=null)
            {
                String[] part=result.split(":");
                request.put("firstname",part[0]);
                request.put("role",part[1]);
                MainDispatcher.getInstance().callView("Home",request);
            }
            else
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
        else MainDispatcher.getInstance().callView("Home", request);

    }
}
