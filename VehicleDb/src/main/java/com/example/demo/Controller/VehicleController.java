package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.VehicleService;
import com.example.demo.module.Vehicle;


@RestController
public class VehicleController 
{
	@Autowired
	VehicleService ser;


	//localhost:8080/addVehicle
	@PostMapping("/addVehicle")
	ResponseEntity<Vehicle> addEmployee(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Vehicle>(ser.addvehicle(v),HttpStatus.CREATED);
	}

	//localhost:8080/deleteVehicle
	@DeleteMapping("/deleteVehicle")
	ResponseEntity<Vehicle> deleteVehicle(@RequestHeader int vid)
	{
		return new ResponseEntity<Vehicle>(ser.deleteVehicle(vid),HttpStatus.OK);
	}

	//localhost:8080/getallvehicle
	@GetMapping("/getallvehicle")
	ResponseEntity<List<Vehicle>> getallvehicle()
	{
		return new ResponseEntity<List<Vehicle>>(ser.getAllVehicle(),HttpStatus.FOUND);
	}

	//localhost:8080/getbyid
	@GetMapping("/getbyid")
	ResponseEntity <Vehicle> getbyid(@RequestHeader int vid)
	{
		return new ResponseEntity<Vehicle>(ser.getById(vid),HttpStatus.FOUND);
	}

	//localhost:8080/getbycolor
	@GetMapping("/getbycolor")
	ResponseEntity<List<Vehicle>>getbycolor(@RequestHeader String vcolor )
	{
		return new ResponseEntity <List<Vehicle>>(ser.getByColor(vcolor),HttpStatus.FOUND);
	}

	//localhost:8080/getsortbyvprice
	@GetMapping("/getsortbyvprice")
	ResponseEntity<List<Vehicle>>getsortbyvprice()
	{
		return new ResponseEntity <List<Vehicle>>(ser.getByVpriceS(),HttpStatus.FOUND);
	}

	//localhost:8080/vehicleUpdate
	@PutMapping("/vehicleUpdate")
	ResponseEntity <Vehicle>vehicleUpdate(@RequestBody Vehicle v)
	{
		return new ResponseEntity <Vehicle>(ser.updateVehicle(v),HttpStatus.OK);
	}

	//localhost:8080/getbyvpricegt
	@GetMapping("/getbyvpricegt")
	ResponseEntity<List<Vehicle>>getbyvpricegt(@RequestHeader Double vprice)
	{
		return new ResponseEntity <List<Vehicle>>(ser.getByVpriceGT(vprice),HttpStatus.FOUND);
	}
	
	//localhost:8080/sortbyvcolorvprice
		@GetMapping("/sortbyvcolorvprice")
		ResponseEntity<List<Vehicle>>sortbyvcolorvprice()
		{
			return new ResponseEntity <List<Vehicle>>(ser.getByVcolorS(),HttpStatus.FOUND);
		}

}
