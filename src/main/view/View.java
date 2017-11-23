package main.view;

import java.util.Map;

public interface View {

    public void showResults (Map<String, Object> data);

    public void showOptions ();

    public void submit();
}
