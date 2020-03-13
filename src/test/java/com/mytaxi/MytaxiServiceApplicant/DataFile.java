package com.mytaxi.MytaxiServiceApplicant;

import java.time.ZonedDateTime;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Entity.DriverEntity;
import com.mytaxi.MytaxiServiceApplicant.constants.OnlineStatus;

@RunWith(MockitoJUnitRunner.class)
public class DataFile {

	 public CarEntity getCar()
	    {
	        CarEntity car = new CarEntity();
	        car.setId(1L);
	        car.setSeatCount(2);
	        car.setRating(11.0F);
	        car.setDateCreated(ZonedDateTime.now());
	        car.setLicensePlate("A01");
	        car.setEngineType("engine01");
	        car.setConvertible(true);
	        return car;
	    }
	 
	 public DriverEntity getDriver()
	    {
		 	DriverEntity driver = new DriverEntity();
	        driver.setId(1L);
	        driver.setDateCreated(ZonedDateTime.now());
	        driver.setDeleted(false);
	        driver.setUsername("test");
	        driver.setPassword("test");
	        driver.setOnlineStatus(OnlineStatus.ONLINE);
	        return driver;
	    }
}
