package waterloo.com.core;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Narula on 10/24/2015.
 */
public class ParkingFinder {

    LatLng currentLocation;
    ArrayList<LatLng> data;

    public ArrayList<LatLng> getParkingArea(LatLng latlng,int vehicle){
        setCurrentLocation(latlng);
        getParkingData(vehicle);


        return null;
    }

    private void getParkingData(int vehicle) {

    }


    public LatLng getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(LatLng currentLocation) {
        this.currentLocation = currentLocation;
    }

}
