/**
 * 
 */
package com.ebay.earthquake.service;

import java.util.List;

import com.ebay.earthquake.model.EarthQuakeModel;
import com.ebay.earthquake.model.ResponseEarthQuakeModel;

/**
 * @author HP
 *
 */
public interface EarthQuakeInterface {

	List<ResponseEarthQuakeModel> getEarthQuakeData(String continent);

}
