package main;

import main.controller.GestoreEccezioni;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;


public class ConnectionSingleton {


    private static Connection connection = null;


    private ConnectionSingleton () {}


    public static Connection getInstance () {
        if (connection == null) {
            try
            {
                Class c = Class.forName("org.gjt.mm.mysql.Driver");
                System.out.println("Ho caricato: " + c.getName());
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/databaseName";
                DriverManagerDataSource dataSource = new DriverManagerDataSource(myUrl, "username", "password");
                dataSource.setDriverClassName(myDriver);
                connection = dataSource.getConnection();
            } catch (Exception e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
            }
        }
        return connection;
    }

}
