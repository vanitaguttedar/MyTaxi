package com.mytaxi.MytaxiServiceApplicant.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mytaxi.MytaxiServiceApplicant.DataFile;
import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Exception.CarNotFoundException;
import com.mytaxi.MytaxiServiceApplicant.Repository.CarRepository;
import com.mytaxi.MytaxiServiceApplicant.service.CarServicesImpl;
public class CarServiceTest extends DataFile{

	@Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServicesImpl carService;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(CarServiceTest.class);
    }
    
    @Test
    public void testFindAllCars()
    {
        Iterable<CarEntity> cars = Collections.singletonList(getCar());
        when(carRepository.findAll()).thenReturn(cars);
        carService.findAll();
        verify(carRepository, times(1)).findAll();
    }
    
    @Test
    public void testCreate() throws CarNotFoundException
    {
        CarEntity car = getCar();
        when(carRepository.save(any(CarEntity.class))).thenReturn(car);
        carService.save(car);
        verify(carRepository, times(1)).save(car);
    }
}
