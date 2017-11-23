package main;


import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        MainDispatcher.getInstance().callAction("Login", "doControl", null);
    }

}
