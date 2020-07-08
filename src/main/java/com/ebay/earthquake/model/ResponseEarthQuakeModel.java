/**
 * 
 */
package com.ebay.earthquake.model;

import java.util.Date;

/**
 * @author HP
 *
 */
public class ResponseEarthQuakeModel {

	private String continent;
	private String country;
	private String cityName;
	private double latitude;
	private double longitude;
	private int magnitude;
	private Date dateTime;
	
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public int getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(int magnitude) {
		this.magnitude = magnitude;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	
	
}
