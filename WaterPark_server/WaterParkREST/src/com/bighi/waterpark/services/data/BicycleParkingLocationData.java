package com.bighi.waterpark.services.data;

public class BicycleParkingLocationData {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getOwnershipType() {
		return ownershipType;
	}
	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}
	
	public BicycleParkingLocationData(String latitude, String longitude, String description, 
			String address, String capacity, String owner, String type, OwnershipType ownershipType) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.address = address;
		this.capacity = capacity;
		this.owner = owner;
		this.type = type;
		this.ownershipType = ownershipType.toString();
	}
	
	private String latitude;
	private String longitude;
	private String description;
	private String address;
	private String capacity;
	private String owner;
	private String type;
	private String ownershipType;
}
