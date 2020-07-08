/**
 * 
 */
package com.ebay.earthquake.model;

import java.util.Date;

/**
 * @author HP
 *
 */
public class EarthQuakeModel {

	private Date dateTime;
    private int depth;
    private double lng;
    private String src;
    private String eqid;
    private double magnitude;
    private double lat;
    
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getEqid() {
		return eqid;
	}
	public void setEqid(String eqid) {
		this.eqid = eqid;
	}
	public double getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}

    
    
}
