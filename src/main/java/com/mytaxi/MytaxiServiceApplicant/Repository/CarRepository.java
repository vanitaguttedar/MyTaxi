package com.mytaxi.MytaxiServiceApplicant.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long>{

}
