package com.mytaxi.MytaxiServiceApplicant.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytaxi.MytaxiServiceApplicant.Entity.DriverEntity;
import com.mytaxi.MytaxiServiceApplicant.constants.OnlineStatus;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity, Long>{
	
	Optional<DriverEntity> findByOnlineStatus(OnlineStatus onlineStatus);
	
	Optional<DriverEntity> findByUsername(String username);
}
