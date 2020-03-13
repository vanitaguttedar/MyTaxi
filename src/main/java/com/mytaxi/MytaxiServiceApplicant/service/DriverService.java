package com.mytaxi.MytaxiServiceApplicant.service;

import java.util.List;
import java.util.Optional;

import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Entity.DriverEntity;
import com.mytaxi.MytaxiServiceApplicant.constants.OnlineStatus;

public interface DriverService {

	Optional<DriverEntity> findById(Long id);

	void deleteById(Long id);

	List<DriverEntity> findAll();

	Optional<DriverEntity> findByStatus(OnlineStatus onlineStatus);
	
	

}
