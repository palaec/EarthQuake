/**
 * 
 */
package com.ebay.earthquake.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ebay.earthquake.model.EarthQuakeModel;
import com.ebay.earthquake.model.ResponseEarthQuakeModel;
import com.ebay.earthquake.service.EarthQuakeInterface;
import com.ebay.earthquake.serviceimpl.EarthQuakeServiceImpl;

/**
 * @author HP
 *
 */
@RestController
public class EarthQuakeController {

	private final EarthQuakeInterface service;
	
	public EarthQuakeController(EarthQuakeServiceImpl impl) {
		this.service = impl;
	}
	
	@GetMapping("/getEarthQuakeData/{continent}")
	public List<ResponseEarthQuakeModel> getEarthQuakeData(@PathVariable(value = "continent") String continent){		
		return service.getEarthQuakeData(continent);
	}
	
}
