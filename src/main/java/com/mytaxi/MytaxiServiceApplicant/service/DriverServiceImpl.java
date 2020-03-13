package com.mytaxi.MytaxiServiceApplicant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Entity.DriverEntity;
import com.mytaxi.MytaxiServiceApplicant.Repository.DriverRepository;
import com.mytaxi.MytaxiServiceApplicant.constants.OnlineStatus;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverRepository driverRepository; 
	
	@Override
	public Optional<DriverEntity> findById(Long id) {
		return driverRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		driverRepository.deleteById(id);
	}

	@Override
	public List<DriverEntity> findAll() {
		List<DriverEntity> result = new ArrayList();
        Iterable<DriverEntity> iterable = driverRepository.findAll();
        iterable.forEach(result::add);
        return result;
	}

	@Override
	public Optional<DriverEntity> findByStatus(OnlineStatus onlineStatus) {
		return driverRepository.findByOnlineStatus(onlineStatus);
	}

}
