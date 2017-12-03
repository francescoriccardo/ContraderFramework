package main.service;

import main.dao.VehicleDAO;
import main.model.Vehicle;

import java.util.List;

public class VehicleService
{
    private VehicleDAO vehicleDAO;

    public VehicleService()
    {
        vehicleDAO=new VehicleDAO();
    }

    public List<Vehicle> getAllvehicle(){ return this.vehicleDAO.getAllvehicle();}
    public boolean insertVehicle(Vehicle vehicle){return this.vehicleDAO.insertVehicle(vehicle);}
}
