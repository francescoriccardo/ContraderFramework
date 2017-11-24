package main.services;

import main.ConnectionSingleton;
import main.model.Gomma;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GommaService {

    public GommaService() {

    }


    public List<Gomma> getAllGomme () {
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * FROM TIRES");
           while (resultSet.next()) {
               String model = resultSet.getString("model");
               String manufacturer = resultSet.getString("manufacturer");
               double price = resultSet.getDouble("price");
               gomme.add(new Gomma(model, manufacturer, price));
           }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

    public void insertGomma(Gomma gomma) {
        Connection connection = ConnectionSingleton.getInstance();


    }
}
