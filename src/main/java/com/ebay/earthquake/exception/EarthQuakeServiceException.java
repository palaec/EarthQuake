/**
 * 
 */
package com.ebay.earthquake.exception;

/**
 * @author HP
 *
 */
public class EarthQuakeServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EarthQuakeServiceException(String string) {
		super(string);
	}

}
