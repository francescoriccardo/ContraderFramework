package main.view;

import main.controller.Request;

import java.util.Map;

public interface View {

    public void showResults (Request request);

    public void showOptions ();

    public void submit();
}
