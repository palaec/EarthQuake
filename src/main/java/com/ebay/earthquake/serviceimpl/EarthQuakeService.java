/**
 * 
 */
package com.ebay.earthquake.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ebay.earthquake.model.Earthquakes;
import com.ebay.earthquake.exception.EarthQuakeServiceException;
import com.ebay.earthquake.model.EarthQuakeModel;
import com.ebay.earthquake.utils.Constants;

/**
 * @author HP
 *
 */
@Service
public class EarthQuakeService {
	
	private final RestTemplateClient restTemplate;

	@Autowired
	public EarthQuakeService(RestTemplateClient restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<EarthQuakeModel> fetchEarthQuakeData(String uri){
	    ResponseEntity<Earthquakes> result = restTemplate.restTemplate().exchange(uri,HttpMethod.GET, null, Earthquakes.class);
	    if(result.getStatusCode() == HttpStatus.OK) {
	    	return result.getBody().getEarthquakes();  
	    }else {
	    	throw new EarthQuakeServiceException("Failed to fetch data from "+ Constants.earthQuakeUri+", Status Code:"+result.getStatusCode());
	    }
		
	}
	
	
}
