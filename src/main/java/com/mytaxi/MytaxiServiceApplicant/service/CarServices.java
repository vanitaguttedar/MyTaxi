package com.mytaxi.MytaxiServiceApplicant.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Exception.CarNotFoundException;

public interface CarServices {
	
	List<CarEntity> findAll(); 
	
	Optional<CarEntity> findById(Long id)throws CarNotFoundException;
	
	CarEntity save(CarEntity car)throws CarNotFoundException;

	void deleteById(Long id)throws CarNotFoundException;

}
