package waterloo.com.core;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Narula on 10/24/2015.
 */
public class ParkingFinder {

    public static void main(String arg[]) {
        ParkingFinder pf = new ParkingFinder();
        LatLng ob = new LatLng(43.4639, 80.5253);
        pf.setCurrentLocation(ob);

        LatLng nob = new LatLng(43.4689, 80.5400);
        pf.passCriteria(nob);

    }

    LatLng currentLocation;
    ArrayList<LocationData> locationData;

    public ArrayList<LatLng> getParkingArea(LatLng latlng, int vehicle) {
        setCurrentLocation(latlng);
        populateParkingData(vehicle);
        return null;
    }

    private void populateParkingData(int vehicle) {
        ArrayList<LocationData> temp = getResponsefromServer(vehicle);
        refineLocationData(temp);

    }

    private void refineLocationData(ArrayList<LocationData> temp) {
        Iterator<LocationData> iterator = temp.iterator();
        while (iterator.hasNext()) {
            LocationData tempLoc = iterator.next();
            if (passCriteria(tempLoc.getLocation()))
                locationData.add(tempLoc);

        }

    }

    private boolean passCriteria(LatLng location) {
        double distance = SphericalUtil.computeDistanceBetween(getCurrentLocation(), location);
        if (distance <= Constants.radius) {
            return true;
        }
        return false;
    }

    private ArrayList<LocationData> getResponsefromServer(int vehicle) {
        ArrayList<LocationData> allData = new ArrayList<LocationData>();
        String vehicleInfo = null;

        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://cloud5.artstor.acit.com/get_weather/" + vehicleInfo);
        try {
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream in = entity.getContent();
            String aJsonString = null;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                JSONObject jObject = new JSONObject(sb.toString());
                LocationData temp = new LocationData();
                aJsonString = jObject.optString("description");
                if (aJsonString != "" && aJsonString != "null") {
                    String desc = jObject.getString("description");
                    String lat = jObject.getString("latitude");
                    String lng = jObject.getString("longitude");
                    String address = jObject.getString("address");

                    LatLng tempOb = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));

                    temp.setLocation(tempOb);
                    temp.setDescription(desc);
                    temp.setAddress(address);
                    temp.setParkingType(vehicle);

                    allData.add(temp);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public LatLng getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(LatLng currentLocation) {
        this.currentLocation = currentLocation;
    }

}
