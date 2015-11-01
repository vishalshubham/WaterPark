package com.bighi.waterpark.services.data;

public class LatLong {
	private String latitude;
	
	private String longitude;
	
	public LatLong(String lat, String longi) {
		this.latitude = lat;
		this.longitude = longi;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
