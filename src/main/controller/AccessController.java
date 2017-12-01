package main.controller;

import main.MainDispatcher;

public class AccessController implements Controller
{
    public AccessController() { }

    @Override
    public void doControl(Request request)
    {
        MainDispatcher.getInstance().callView("Access", request);
    }
}
