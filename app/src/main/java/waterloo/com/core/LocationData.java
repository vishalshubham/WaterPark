package waterloo.com.core;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

/**
 * Created by Narula on 10/24/2015.
 */
public class LocationData {

    String id;
    LatLng location;

    String Description;
    String Address;
    String name;
    String email;
    String contact_Num;

    int ownershipType;
    String capacity;
    int vehicleTypes;
    Boolean isCarBikeParking;
    Boolean isBicycleParking;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsCarBikeParking() {
        return isCarBikeParking;
    }

    public void setIsCarBikeParking(Boolean isCarBikeParking) {
        this.isCarBikeParking = isCarBikeParking;
    }

    public Boolean getIsBicycleParking() {
        return isBicycleParking;
    }

    public void setIsBicycleParking(Boolean isBicycleParking) {
        this.isBicycleParking = isBicycleParking;
    }



    public float getAmountPerDay() {
        return amountPerDay;
    }

    public void setAmountPerDay(float amountPerDay) {
        this.amountPerDay = amountPerDay;
    }

    float amountPerDay;

    public String getMotorcycleAllowed() {
        return motorcycleAllowed;
    }

    public void setMotorcycleAllowed(String motorcycleAllowed) {
        this.motorcycleAllowed = motorcycleAllowed;
    }

    String motorcycleAllowed;

    String startDate, endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_Num() {
        return contact_Num;
    }

    public void setContact_Num(String contact_Num) {
        this.contact_Num = contact_Num;
    }

    public int getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(int vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(int parkingType) {
        this.ownershipType = parkingType;
    }


    @Override
    public String toString() {
        return "{" +
                "\"latitude\":\"" + location.latitude + "\"" +
                ", \"longitude\":\"" + location.longitude + "\"" +
                ", \"description\":\"" + Description + "\"" +
                ", \"address\":\"" + Address + "\"" +
                ", \"owner\":\"" + name + "\"" +
                ", \"ownerEmail\":\"" + email + "\"" +
                ", \"type\":\"" + "" + "\"" +
                ", \"ownerPhone\":\"" + contact_Num + "\"" +
                ", \"ownershipType\":\"" + ownershipType + "\"" +
                ", \"capacity\":\"" + capacity + "\"" +
                ", \"startDate\":\"" + startDate + "\"" +
                ", \"endDate\":\"" + endDate + "\"" +
                ", \"amountPerDay\":\"" + amountPerDay + "\"" +
                ", \"motorcycleAllowed\":\"" + motorcycleAllowed + "\"" +
                ", \"isBicycleParking\":\"" + isBicycleParking + "\"" +
                ", \"isCarBikeParking\":\"" + isCarBikeParking + "\"" +
                ", \"id\":\"" + id + "\"" +
                '}';
    }
}
