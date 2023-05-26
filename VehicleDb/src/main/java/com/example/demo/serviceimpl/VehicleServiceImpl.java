package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.demo.Exception.ResourseNotFoundException;
import com.example.demo.Service.VehicleService;
import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;


@Service
public class VehicleServiceImpl implements VehicleService
{
	@Autowired
	VehicleRepo repo;

	@Override
	public Vehicle addvehicle(Vehicle v) {
		
		return repo.save(v);
	}

	@Override
	public Vehicle deleteVehicle(int vid) {
		
		Vehicle v= repo.findById(vid).orElseThrow(()->new ResourseNotFoundException ("vehicle","VId",vid));
		 repo.deleteById(vid);
		 return v;	 
	}

	@Override
	public List<Vehicle> getAllVehicle() 
	{
		
		return repo.getAllVehicle();
	}

	@Override
	public Vehicle getById(int vid) 
	{
		Vehicle v=repo.findById(vid).orElseThrow(()->new ResourseNotFoundException ("vehile","VId",vid));
		return v;
	}

	@Override
	public List<Vehicle> getByColor(@RequestHeader String vcolor) {
		
		return repo.getByColor(vcolor);
	}

	@Override
	public List<Vehicle> getByVpriceS() {
		
		return repo.getByVpriceS();
	}

	@Override
	public Vehicle updateVehicle(Vehicle v) 
	{
		Vehicle v1=repo.findById(v.getVid()).orElse(null);
		
		if(v1 !=null)
		{
			v1.setVname(v.getVname());
			v1.setVprice(v.getVprice());
			v1.setVmodel(v.getVmodel());
			v1.setVcolor(v.getVcolor());
			return repo.save(v1);
		}
		else
		{
			throw new ResourseNotFoundException("Vehicle","vid",v.getVid());
		}
		
	}

	@Override
	public List<Vehicle> getByVpriceGT(double vprice) 
	{
		return repo.getByVpriceGT(vprice);
	}

	@Override
	public List<Vehicle> getByVcolorS() {
		
		return repo.getByVcolorsort();
	}
	
}