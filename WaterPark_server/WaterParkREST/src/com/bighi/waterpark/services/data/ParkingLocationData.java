package com.bighi.waterpark.services.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ParkingLocationData {

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	@Override
	public String toString() {
		GregorianCalendar cal1 = null;
		if(startDate != null) {
			cal1 = new GregorianCalendar();
			cal1.setTimeInMillis(startDate.getTime());
			cal1.add(Calendar.HOUR, 5);
		}

		GregorianCalendar cal2 = null;
		if(endDate != null) {
			cal2 = new GregorianCalendar();
			cal2.setTimeInMillis(endDate.getTime());
			cal2.add(Calendar.HOUR, 5);
		}

		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		
		String s1 = "1970-01-01";
		if(cal1 != null) {
			s1 = df.format(cal1.getTime());
		}
		
		String s2 = "1970-01-01";
		if(cal2 != null) {
			s2 = df.format(cal2.getTime());
		}
		
		return "{" 
				+ "\"latitude\":\"" + latitude + "\""
				+ ", \"longitude\":\"" + longitude + "\""
				+ ", \"description\":\"" + description + "\""
				+ ", \"address\":\"" + address + "\""
				+ ", \"capacity\":\"" + capacity + "\"" 
				+ ", \"owner\":\"" + owner + "\"" 
				+ ", \"type\":\""+ type + "\""
				+ ", \"motorcycleAllowed\":\"" + motorcycleAllowed + "\""
				+ ", \"accessibleAvailable\":\"" + accessibleAvailable + "\""
				+ ", \"ownershipType\":\"" + ownershipType + "\"" 
				+ ", \"ownerEmail\":\"" + ownerEmail + "\"" 
				+ ", \"ownerPhone\":\"" + ownerPhone + "\"" 
				+ ", \"amountPerDay\":\"" + amountPerDay + "\"" 
				+ ", \"startDate\":\""+ s1  + "\""
				+ ", \"endDate\":\"" + s2 + "\""
				+ ", \"isBicycleParking\":\"" + isBicycleParking + "\"" 
				+ ", \"occupied\":\"" + occupied + "\""
				+ ", \"id\":\"" + id + "\""
				+ ", \"isCarparking\":\""+ isCarBikeParking + "\"}";
	}

	public ParkingLocationData() {

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

	public String getMotorcycleAllowed() {
		return motorcycleAllowed;
	}

	public void setMotorcycleAllowed(String motorcycleAllowed) {
		this.motorcycleAllowed = motorcycleAllowed;
	}

	public String getAccessibleAvailable() {
		return accessibleAvailable;
	}

	public void setAccessibleAvailable(String accessibleAvailable) {
		this.accessibleAvailable = accessibleAvailable;
	}

	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getAmountPerDay() {
		return amountPerDay;
	}

	public void setAmountPerDay(String amountPerDay) {
		this.amountPerDay = amountPerDay;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getIsBicycleParking() {
		return isBicycleParking;
	}

	public void setIsBicycleParking(boolean isBicycleParking) {
		this.isBicycleParking = isBicycleParking;
	}

	public boolean getIsCarBikeParking() {
		return isCarBikeParking;
	}

	public void setIsCarBikeParking(boolean isCarBikeParking) {
		this.isCarBikeParking = isCarBikeParking;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public ParkingLocationData(String id, String latitude, String longitude,
			String description, String address, String capacity, String owner,
			String type, String motorcycleAllowed, String accessibleAvailable,
			OwnershipType ownershipType, String ownerEmail, String ownerPhone,
			String amountPerDay, Date startDate, Date endDate,
			boolean isBicycleParking, boolean isCarBikeParking
	// , String _id
	) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.address = address;
		this.capacity = capacity;
		this.owner = owner;
		this.type = type;
		this.motorcycleAllowed = motorcycleAllowed;
		this.accessibleAvailable = accessibleAvailable;
		this.ownershipType = ownershipType.toString();
		this.ownerEmail = ownerEmail;
		this.ownerPhone = ownerPhone;
		this.amountPerDay = amountPerDay;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isBicycleParking = isBicycleParking;
		this.isCarBikeParking = isCarBikeParking;
		this.id = id;
		// this._id = _id;
	}
	
	public ParkingLocationData(String id, String latitude, String longitude, String description, 
			String address, String capacity, String owner, String type, OwnershipType ownershipType) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.address = address;
		this.capacity = capacity;
		this.owner = owner;
		this.type = type;
		this.ownershipType = ownershipType.toString();
		this.id = id;
	}
	
	public ParkingLocationData(String id, String latitude, String longitude, String description, 
			String address, String capacity, String owner, String type, String motorcycleAllowed, 
			String accessibleAvailable, OwnershipType ownershipType
			//, String _id
			) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.address = address;
		this.capacity = capacity;
		this.owner = owner;
		this.type = type;
		this.motorcycleAllowed = motorcycleAllowed;
		this.accessibleAvailable = accessibleAvailable;
		this.ownershipType = ownershipType.toString();
		this.id = id;
		//this._id = _id;
	}

	private String latitude;
	private String longitude;
	private String description;
	private String address;
	private String capacity;
	private String owner; // name of the owner
	private String type; // 'SURFACE' field
	private String motorcycleAllowed;
	private String accessibleAvailable;
	private String ownershipType;
	private String ownerEmail;
	private String ownerPhone;
	private String amountPerDay;
	private Date startDate;
	private Date endDate;
	private boolean isBicycleParking;
	private boolean isCarBikeParking;
	
	private String id;
	private boolean occupied = false;

	/*
	 * private String _id;
	 * 
	 * public String getId() { return _id; } public void setId(String _id) {
	 * this._id = _id; }
	 */
}
