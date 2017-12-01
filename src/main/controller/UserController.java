package main.controller;

import main.MainDispatcher;

public class UserController implements Controller
{

    @Override
    public void doControl(Request request)
    {
        String choiceLogin = (String) request.get("choiceLogin");
        String role = (String) request.get("role");

        if(role!=null)
        {
            switch(role)
            {
                case "admin":
                {
                    int choice=(Integer) request.get("choice");
                    switch (choice)
                    {
                        case 3:
                        {
                            request.put("mode","allUser");
                            MainDispatcher.getInstance().callView("User", request);
                        }
                        break;
                    }

                }
                break;
                case "user":
                {

                }
            }
        }
        if(choiceLogin!=null)
        {
            switch (choiceLogin)
            {
                case "login":
                {
                    MainDispatcher.getInstance().callView("Login", request);
                }
                break;
                case "sigIn":
                {
                    request.put("mode","sigIn");
                    MainDispatcher.getInstance().callView("User", request);
                }
            }
        }
    }
}
