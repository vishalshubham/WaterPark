package waterloo.com.core;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Narula on 10/24/2015.
 */
public class LocationData {
    LatLng location;
    String Description;
    String Address;
    int parkingType;

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

    public int getParkingType() {
        return parkingType;
    }

    public void setParkingType(int parkingType) {
        this.parkingType = parkingType;
    }


}
