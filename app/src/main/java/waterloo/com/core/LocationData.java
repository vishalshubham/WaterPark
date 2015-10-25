package waterloo.com.core;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Narula on 10/24/2015.
 */
public class LocationData {
    LatLng location;

    String Description;
    String Address;
    String name;
    String email;
    String contact_Num;

    int ownershipType;
    String capacity;
    int vehicleTypes;


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


}
