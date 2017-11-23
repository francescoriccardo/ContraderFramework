package main;

import main.controller.Controller;
import main.view.View;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainDispatcher<T> {

    private MainDispatcher() {
    }

    private static MainDispatcher instance;

    public static MainDispatcher getInstance() {
        if (instance == null) {
            instance = new MainDispatcher();
        }
        return instance;
    }

    public void callAction(String controller, String action, T data) {
        data = (T) new HashMap<String, Object>();
        Controller oggettoController = (Controller) ReflectionUtils.instantiateClass("main.controller." + controller + "Controller");
        try {
            Method metodo = oggettoController.getClass().getMethod(action, data.getClass());
            metodo.invoke(oggettoController, data);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void callView(String view, Map<String, Object> data) {
        View oggettoView = (View) ReflectionUtils.instantiateClass("main.view." + view + "View");
        oggettoView.showResults(data);
        oggettoView.showOptions();
        oggettoView.submit();
    }

}
