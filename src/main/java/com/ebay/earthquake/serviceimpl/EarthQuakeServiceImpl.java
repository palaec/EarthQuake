/**
 * 
 */
package com.ebay.earthquake.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebay.earthquake.model.EarthQuakeModel;
import com.ebay.earthquake.model.ResponseEarthQuakeModel;
import com.ebay.earthquake.service.EarthQuakeInterface;
import com.ebay.earthquake.utils.Constants;
import com.ebay.earthquake.utils.UtilMethods;

/**
 * @author HP
 *
 */
@Service
public class EarthQuakeServiceImpl implements EarthQuakeInterface{

	private final EarthQuakeService earthQuakeService;
	private final UtilMethods util;
	
	public EarthQuakeServiceImpl(EarthQuakeService earthQuakeService,UtilMethods util) {
		this.earthQuakeService = earthQuakeService;
		this.util = util;
	}
	
	@Override
	public List<ResponseEarthQuakeModel> getEarthQuakeData(String continent) {
		List<EarthQuakeModel> dataFromUri = earthQuakeService.fetchEarthQuakeData(Constants.earthQuakeUri);
		List<ResponseEarthQuakeModel> responseList = new ArrayList<ResponseEarthQuakeModel>();
		for(EarthQuakeModel uriData : dataFromUri) {
			if(uriData.getSrc().equals(continent)) {
				ResponseEarthQuakeModel response = new ResponseEarthQuakeModel();
				response.setLongitude(uriData.getLng());
				response.setLatitude(uriData.getLat());
				response.setContinent(uriData.getSrc());
				response.setMagnitude(util.getMagnitudeValue(uriData.getMagnitude()));
				response.setCityName("New York");
				response.setCountry("USA");
				responseList.add(response);
			}
		}
		
		return responseList;
	}

}
