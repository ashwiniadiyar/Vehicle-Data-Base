package com.example.demo.Service;

import java.util.List;

import com.example.demo.module.Vehicle;

public interface VehicleService 
{

	public Vehicle addvehicle(Vehicle v);
	//Create an api to add vehicle details.
	
	public Vehicle deleteVehicle (int vid);
	//Create an api delete the vehicle based on vid
	
	public List<Vehicle> getAllVehicle();
	//Create an api to fetch all the details in database.
	
	public Vehicle getById(int vid);
	//Create an api to fetch details of vehicle based on vid.
	
	public List<Vehicle> getByColor(String vcolor);
	//Create an api to fetch details of vehicle based on color.

	public List<Vehicle> getByVpriceS();
	//Create an api to fetch details of vehicle in sorted manner based on vprice.

	public Vehicle updateVehicle(Vehicle v);
      // Create an api to update the vehicle details based on vid.
	
	public List<Vehicle> getByVpriceGT(double vprice);
//	Create an api to fetch details of vehicle for vprice more than 1000000.
	
	public List<Vehicle> getByVcolorS();
//	• Create an api to fetch details of vehicle in sorted manner based on
//	vprice(If vprice is same sort based on vcolor in alphabetic manner).
	
	
}
