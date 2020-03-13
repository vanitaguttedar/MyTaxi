package com.mytaxi.MytaxiServiceApplicant.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mytaxi.MytaxiServiceApplicant.DataFile;
import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.controller.CarController;
import com.mytaxi.MytaxiServiceApplicant.service.CarServices;
import com.mytaxi.MytaxiServiceApplicant.Entity.CarEntity;
import com.mytaxi.MytaxiServiceApplicant.Entity.*;;

public class CarControllerTest extends DataFile{

	private MockMvc mvc;
	
	@Mock
	private CarServices carService;

	@InjectMocks
	private CarController carController;
	
	@BeforeClass
    public static void setup()
    {
        MockitoAnnotations.initMocks(CarController.class);
    }

    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(carController).dispatchOptions(true).build();
    }
    
    @Test
    public void testGetCar() throws Exception
    {
        CarEntity carData = getCar();
        doReturn(carData).when(carService).findById(any(Long.class));
        MvcResult result =
            mvc
                .perform(get("/cars/{carId}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("A01"));
    }
    
    @Test
    public void deleteCar() throws Exception
    {
        doNothing().when(carService).deleteById(any(Long.class));
        carController.deleteById(1L);
        MvcResult result =
            mvc
                .perform(delete("/cars/{carId}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
    
    @Test
    public void createCar() throws Exception
    {
    	CarEntity carData = getCar();

        doReturn(carData).when(carService).save(any(CarEntity.class));
        carController.createCar(carData);
        MvcResult result =
            mvc.perform(
                    post("/add")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();

        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("test"));
    }
    
    @Test
    public void getAllCars() throws Exception
    {
        List<CarEntity> cars = Collections.singletonList(getCar());
        doReturn(cars).when(carService).findAll();
        carController.findAllCar();
        MvcResult result =
            mvc.perform(get("/cars"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("A01"));
    }
}
