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
import com.ebay.earthquake.serviceimpl.EarthQuakeService;
import com.ebay.earthquake.serviceimpl.RestTemplateClient;
import com.ebay.earthquake.utils.Constants;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class EarthQuakeServiceTests {

	@InjectMocks
	private EarthQuakeService serviceImpl;
	
	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private RestTemplateClient restTemplate;
	
	
	
	@Test
	void fetchEarthQuakeData_test() {
		
		EarthQuakeModel model = new EarthQuakeModel();
		model.setMagnitude(8.8);
		
		List<EarthQuakeModel> earthquakesList= new ArrayList<EarthQuakeModel>();
		earthquakesList.add(model);
		
		Earthquakes earthquakes = new Earthquakes();
		earthquakes.setEarthquakes(earthquakesList);
		
		ResponseEntity<Earthquakes> responseEntity = new ResponseEntity<>(earthquakes, HttpStatus.OK);
		
		when(restTemplate.restTemplate().exchange(ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<Earthquakes>>any())).thenReturn(responseEntity);
		
		List<EarthQuakeModel> actualData = serviceImpl.fetchEarthQuakeData(Constants.earthQuakeUri);		
		Assert.assertEquals(8.8,actualData.get(0).getMagnitude(),0);		
	}

	@Test
	void fetchEarthQuakeDataException_test() {
		
		EarthQuakeModel model = new EarthQuakeModel();
		model.setMagnitude(8.8);
		
		List<EarthQuakeModel> earthquakesList= new ArrayList<EarthQuakeModel>();
		earthquakesList.add(model);
		
		Earthquakes earthquakes = new Earthquakes();
		earthquakes.setEarthquakes(earthquakesList); 
		
		ResponseEntity<Earthquakes> responseEntity = new ResponseEntity<>(earthquakes, HttpStatus.BAD_REQUEST);
		
		when(restTemplate.restTemplate().exchange(ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<Earthquakes>>any())).thenReturn(responseEntity);
		
		Exception exception = assertThrows(EarthQuakeServiceException.class, () -> {
			serviceImpl.fetchEarthQuakeData(Constants.earthQuakeUri);	
		});
		
		
		Assert.assertTrue(exception.getMessage().contains("Failed to fetch data from"));	
	}
	
	@Test
	void fetchEarthQuakeDataWrongUrl_test() {		
		Exception exception = assertThrows(EarthQuakeServiceException.class, () -> {
			serviceImpl.fetchEarthQuakeData("http://test");	
		});
		Assert.assertTrue(exception.getMessage().contains("Failed to fetch data from"));	
	}
	
}
