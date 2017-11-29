package main.controller;

import main.MainDispatcher;

public class GommaController implements Controller {


    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        switch (choice) {
            case 1:
               request.put("mode", "insert");
               break;
            case 2:
                request.put("mode", "all");
                break;
            case 3:
                request.put("mode","allBrandForVehicle");
        }
        MainDispatcher.getInstance().callView("Gomma", request);

    }
}
