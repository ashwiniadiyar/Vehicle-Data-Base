package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>
{
	@Query(value="select * from Vehicle",nativeQuery = true)
	List<Vehicle> getAllVehicle();
	
	@Query(value="select * from Vehicle where vcolor=?1",nativeQuery = true)
    List<Vehicle> getByColor(String vcolor);
	
	@Query(value="select * from Vehicle order by vprice,vcolor asc",nativeQuery = true)
	List<Vehicle> getByVcolorsort();
	
	@Query(value="select * from Vehicle where vprice>?1",nativeQuery = true)
	List<Vehicle> getByVpriceGT(double vprice);
	
	@Query(value="select * from Vehicle order by vprice asc",nativeQuery = true)
	List<Vehicle> getByVpriceS();
}
