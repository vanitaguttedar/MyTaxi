package com.mytaxi.MytaxiServiceApplicant.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Exception.CarNotFoundException;
import com.mytaxi.MytaxiServiceApplicant.Repository.CarRepository;
import com.mytaxi.MytaxiServiceApplicant.service.CarServices;

@RestController
@ComponentScan(basePackages = "com.mytaxi.MytaxiServiceApplicant.service")
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarServices carSer;
	
	// To retrive all car
	@GetMapping("/all")
	public List<CarEntity> findAllCar(){
		return carSer.findAll();
	}
	
	// To retrive car by id
	@GetMapping("cars/{id}")
	public Optional<CarEntity> retrieveCarByID(@PathVariable Long id) {
		Optional<CarEntity> listcar =carSer.findById(id);
		if (!listcar.isPresent())
			throw new CarNotFoundException(String.format("Car ID-%s Not avaialble", id));
		return listcar;
	}
	
	//add a car list
	@PostMapping("/add") //to insert the car details
	public Optional<CarEntity> createCar(@RequestBody CarEntity car) {
		CarEntity savedCar = carSer.save(car);
		return carSer.findById(savedCar.getId());
	}
	
	// Delete the car detail by id
	@DeleteMapping("/delete/{id}") 
	public void deleteById(@PathVariable Long id) {
		if (!carSer.findById(id).isPresent())
			throw new CarNotFoundException(String.format("Car ID-%s Not avaialble", id));
		carSer.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
    public Optional<CarEntity> updateCar(@PathVariable Long id, @RequestBody CarEntity car) throws CarNotFoundException
    {
		Optional<CarEntity> carid = carSer.findById(id);
		if (!carid.isPresent())
			throw new CarNotFoundException(String.format("Car ID-%s Not avaialble", id));
		
		CarEntity savedCar = carSer.save(car);
		return carSer.findById(savedCar.getId());
    }
}
