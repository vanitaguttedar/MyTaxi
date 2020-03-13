package com.mytaxi.MytaxiServiceApplicant.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mytaxi.MytaxiServiceApplicant.DataFile;
import com.mytaxi.MytaxiServiceApplicant.Entity.DriverEntity;
import com.mytaxi.MytaxiServiceApplicant.Repository.DriverRepository;
import com.mytaxi.MytaxiServiceApplicant.service.DriverService;
import com.mytaxi.MytaxiServiceApplicant.service.DriverServiceImpl;
import com.mytaxi.MytaxiServiceApplicant.constants.OnlineStatus;

public class DriverServiceTest extends DataFile{

	@Mock
	private DriverRepository driverRepository;

	@InjectMocks
	private DriverServiceImpl driverService;

	@BeforeClass
	public static void setUp() {
		MockitoAnnotations.initMocks(DriverService.class);
	}

	@Test
    public void testCreate()
    {
        DriverEntity driver = getDriver();
        when(driverRepository.save(any(DriverEntity.class))).thenReturn(driver);
        verify(driverRepository, times(1)).save(any(DriverEntity.class));
    }


//    @Test
//    public void testFindByOnlineStatus()
//    {
//        List<DriverEntity> drivers = Collections.singletonList(getDriver());
//        when(driverRepository.findByOnlineStatus(any(OnlineStatus.class))).thenReturn(drivers);
//        driverRepository.findByOnlineStatus(OnlineStatus.ONLINE);
//        verify(driverRepository, times(1)).findByOnlineStatus(any(OnlineStatus.class));
//    }

}
