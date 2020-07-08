package com.ebay.earthquake;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ebay.earthquake.exception.EarthQuakeServiceException;
import com.ebay.earthquake.model.EarthQuakeModel;
import com.ebay.earthquake.model.Earthquakes;
import com.ebay.earthquake.model.ResponseEarthQuakeModel;
import com.ebay.earthquake.serviceimpl.EarthQuakeService;
import com.ebay.earthquake.serviceimpl.EarthQuakeServiceImpl;
import com.ebay.earthquake.serviceimpl.RestTemplateClient;
import com.ebay.earthquake.utils.Constants;
import com.ebay.earthquake.utils.UtilMethods;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class EarthQuakeServiceImplTests {

	@InjectMocks
	private EarthQuakeServiceImpl serviceImpl;
	
	@Mock
	private EarthQuakeService restService;
	
	@Mock
	private UtilMethods util;
	
	
	
	@Test
	void fetchEarthQuakeData_test() {
		
		EarthQuakeModel model = new EarthQuakeModel();
		model.setMagnitude(8.8);
		model.setSrc("us");
		
		List<EarthQuakeModel> earthquakesList= new ArrayList<EarthQuakeModel>();
		earthquakesList.add(model);
		
		
		when(restService.fetchEarthQuakeData(Mockito.anyString())).thenReturn(earthquakesList);
		
		List<ResponseEarthQuakeModel> actualData = serviceImpl.getEarthQuakeData("us");		
		Assert.assertEquals(8.0,actualData.get(0).getMagnitude(),0);		
	}


	
}
