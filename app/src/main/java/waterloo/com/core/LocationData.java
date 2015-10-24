package waterloo.com.core;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Narula on 10/24/2015.
 */
public class LocationData {
    LatLng location;
    String Description;

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

}
