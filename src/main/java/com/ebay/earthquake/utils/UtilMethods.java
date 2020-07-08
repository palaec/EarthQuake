/**
 * 
 */
package com.ebay.earthquake.utils;

import org.springframework.stereotype.Component;

/**
 * @author HP
 *
 */
@Component
public class UtilMethods {
	
	public int getMagnitudeValue(double magnitude) {
		
		Long l = Math.round(magnitude);
		
		return l.intValue();
		
	}
	

}
