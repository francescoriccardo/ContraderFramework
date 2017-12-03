package main.controller;

import main.MainDispatcher;

public class VehicleController implements Controller
{
    @Override
    public void doControl(Request request)
    {
       String role = (String) request.get("role");
        int choice=(Integer) request.get("choice");

        switch (role)
        {
            case "admin":
            {
                switch (choice)
                {
                    case 4:
                    {
                        request.put("mode","allVehicle");
                        MainDispatcher.getInstance().callView("Vehicle", request);
                    }
                    case 5:
                    {
                        request.put("mode","insertVehicle");
                        MainDispatcher.getInstance().callView("Vehicle", request);
                    }
                }
            }break;
            case "user":
            {
                switch (choice)
                {
                    case 3:
                    {
                        request.put("mode","getIdVehicle");
                        MainDispatcher.getInstance().callView("Vehicle", request);
                    }
                }
            }
        }

    }

}
