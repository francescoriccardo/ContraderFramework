package main.view;

import main.view.View;

import java.util.Map;
import java.util.Scanner;

public class HomeView implements View {

    private int choice;

    public void showResults (Map<String, Object> data) {

    }


    public void showOptions () {
        System.out.println("Benvenuto in ContraderFramework");
        System.out.println("");
        System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserisci gomma");
        System.out.println("2) Visualizza gomme disponibili");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        switch (this.choice) {
            case 1:

        }
    }


    protected String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


}
