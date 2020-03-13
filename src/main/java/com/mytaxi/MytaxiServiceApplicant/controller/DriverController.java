package com.mytaxi.MytaxiServiceApplicant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Entity.DriverEntity;
import com.mytaxi.MytaxiServiceApplicant.Exception.CarNotFoundException;
import com.mytaxi.MytaxiServiceApplicant.constants.OnlineStatus;
import com.mytaxi.MytaxiServiceApplicant.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	// To retrive car by id
	@GetMapping("driver/{id}")
	public Optional<DriverEntity> retrieveDirverByID(@PathVariable Long id) {
		Optional<DriverEntity> listDriver =driverService.findById(id);
		if (!listDriver.isPresent())
			throw new CarNotFoundException(String.format("Driver ID-%s Does not exists", id));
		return listDriver;
	}
	
	// Delete the car detail by id
	@DeleteMapping("/delete/{id}") 
	public void deleteById(@PathVariable Long id) {
		if (!driverService.findById(id).isPresent())
			throw new CarNotFoundException(String.format("Driver ID-%s Does not exists", id));
		driverService.deleteById(id);
	}
	
	@GetMapping("/find/status")
	public Optional<DriverEntity> findDriversByStatus(@RequestParam OnlineStatus onlineStatus)throws CarNotFoundException
	{
		Optional<DriverEntity> listDriver =driverService.findByStatus(onlineStatus);
		if (!listDriver.isPresent())
			throw new CarNotFoundException(String.format("Online Driver ID-%s Does not exists", onlineStatus));
		return listDriver;
	}
	 
	@GetMapping("/all")
	public List<DriverEntity> getAllDriver(){
		return driverService.findAll();
	}
}
