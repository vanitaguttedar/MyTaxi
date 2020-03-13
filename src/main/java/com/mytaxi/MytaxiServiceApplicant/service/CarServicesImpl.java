package com.mytaxi.MytaxiServiceApplicant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Exception.CarNotFoundException;
import com.mytaxi.MytaxiServiceApplicant.Repository.CarRepository;

@Service
public class CarServicesImpl implements CarServices{

	@Autowired
	private CarRepository carRepo;
	
	@Override
	public List<CarEntity> findAll() {
		 List<CarEntity> result = new ArrayList();
	        Iterable<CarEntity> iterable = carRepo.findAll();
	        iterable.forEach(result::add);
	        return result;
	}

	@Override
	public Optional<CarEntity> findById(Long id)throws CarNotFoundException {
		List<CarEntity> result = new ArrayList();
		return carRepo.findById(id);
	}

	@Override
	public CarEntity save(CarEntity car) throws CarNotFoundException{
		return carRepo.save(car);
	}

	@Override
	public void deleteById(Long id) throws CarNotFoundException{
		carRepo.deleteById(id);
	}

}
