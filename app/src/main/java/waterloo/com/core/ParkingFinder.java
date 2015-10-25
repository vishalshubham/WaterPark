package waterloo.com.core;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.maps.android.SphericalUtil;

import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
        System.out.println("hello");
        pf.getResponsefromServer(Constants.BICYCLE);

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
        String vehicleInfo = getVehicle(vehicle);

        //HttpClient client = new DefaultHttpClient();
        //HttpGet httpGet = new HttpGet("http://ec2-52-26-80-237.us-west-2.compute.amazonaws.com/waterpark/rest/parking/" + vehicleInfo);
        try {
            String url = "http://ec2-52-26-80-237.us-west-2.compute.amazonaws.com/waterpark/rest/parking/" + vehicleInfo;
            URL obj = new URL(url);
            HttpURLConnection client = (HttpURLConnection) obj.openConnection();
            client.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            //System.out.println();
            //sb.toString(
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JsonArray jArray = gson.fromJson(sb.toString(), JsonArray.class);

            for (int i = 0; i < jArray.size(); i++) {
                JsonObject jObject = jArray.get(i).getAsJsonObject();
                LocationData temp = new LocationData();
                String desc = jObject.get("description").getAsString();
                String lat = jObject.get("latitude").getAsString();
                String lng = jObject.get("longitude").getAsString();
                String address = jObject.get("address").getAsString();
                String capacity = jObject.get("capacity").getAsString();
                String ownershipType = jObject.get("ownershipType").getAsString();

                String mcAllowed;
                if (vehicleInfo.equalsIgnoreCase("carbike")) {
                    mcAllowed = jObject.get("motorcycleAllowed").getAsString();
                    if (mcAllowed.equalsIgnoreCase("Y"))
                        temp.setVehicleTypes(Constants.MOTOR_CYCLE | Constants.CAR);
                    else
                        temp.setVehicleTypes(Constants.CAR);
                } else
                    temp.setVehicleTypes(Constants.BICYCLE);


                LatLng tempOb = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));

                temp.setCapacity(capacity);
                temp.setLocation(tempOb);
                temp.setDescription(desc);
                temp.setAddress(address);
                temp.setOwnershipType(matchParking(ownershipType));


                allData.add(temp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private int matchParking(String parkingType) {
        if (parkingType.equalsIgnoreCase("PRIVATE"))
            return Constants.PRIVATE_PARKING;
        else
            return Constants.PUBLIC_PARKING;
    }

    private String getVehicle(int vehicle) {
        switch (vehicle) {
            case Constants.BICYCLE:
                return "bicycle";
            case Constants.CAR:
                return "carbike";
            default:
                return "carbike";
        }

    }

    public LatLng getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(LatLng currentLocation) {
        this.currentLocation = currentLocation;
    }

}
