package com.mytaxi.MytaxiServiceApplicant.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.mytaxi.MytaxiServiceApplicant.Entity.DriverEntity;
import com.mytaxi.MytaxiServiceApplicant.controller.DriverController;
import com.mytaxi.MytaxiServiceApplicant.service.DriverService;
import com.mytaxi.MytaxiServiceApplicant.Entity.DriverEntity;
import com.mytaxi.MytaxiServiceApplicant.service.DriverService;

public class DriverControllerTest extends DataFile{

	private MockMvc mvc;

    @Mock
    private DriverService driverService;

    @InjectMocks
    private DriverController driverController;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(DriverController.class);
    }
    
    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(driverController).dispatchOptions(true).build();
    }

    @Test
    public void testGetDriver() throws Exception
    {
        DriverEntity driverData = getDriver();
        
        doReturn(driverData).when(driverService).findById(any(Long.class));
        MvcResult result =
            mvc.perform(get("/drivers/{driverId}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("test"));
    }
    
//    @Test
//    public void testCreateDriver() throws Exception
//    {
//        DriverEntity driverData = getDriver();        
//        doReturn(driverData).when(driverService).create(any(DriverEntity.class));
//        
//        driverController.createDriver(driverData);
//        MvcResult result =
//            mvc
//                .perform(
//                    post("/v1/drivers")
//                        .contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonInString))
//                .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
//        final String responseBody = result.getResponse().getContentAsString();
//        Assert.assertTrue(responseBody.contains("test"));
//
//    }


    @Test
    public void testDeleteDriver() throws Exception
    {
        doNothing().when(driverService).deleteById(any(Long.class));
        driverController.deleteById(1L);
        MvcResult result =
            mvc.perform(delete("/drivers/{driverId}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
}
