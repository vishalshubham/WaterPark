package waterpark.com.waterpark;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.location.Location;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import waterloo.com.core.BulkData;
import waterloo.com.core.Constants;
import waterloo.com.core.LocationData;
import waterloo.com.core.ParkingFinder;
import waterpark.com.waterpark.R;

public class MainActivity extends Activity {

    public static final String DEBUGTAG = "DEBUG_VC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int vehicle = getIntent().getExtras().getInt("vehicle", 2);
        final int searchType = getIntent().getExtras().getInt("searchType", 2);

        double longitude = 0.0;
        double latitude = 0.0;

        if(searchType == 1){
            longitude = getIntent().getExtras().getDouble("longitude");
            latitude = getIntent().getExtras().getDouble("latitude");
            Log.d(DEBUGTAG, "Longitude for 1: " + longitude);
            Log.d(DEBUGTAG, "Latitude for 1: " + latitude);
        }
        else{
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            try{
                Criteria criteria = new Criteria();
                String bestProvider = lm.getBestProvider(criteria, false);
                Location location = lm.getLastKnownLocation(bestProvider);

                longitude = location.getLongitude();
                latitude = location.getLatitude();
                Log.d(DEBUGTAG, "Longitude for 2: " + longitude);
                Log.d(DEBUGTAG, "Latitude for 2: " + latitude);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        final GoogleMap mMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

        final LatLng coordinate = new LatLng(latitude, longitude);                                     //LatLng coordinate = new LatLng(43.4619415152536, -80.5222363389286);
        Log.d(DEBUGTAG, "1---------------------");

        final BulkData bulkData = new BulkData();
        final ArrayList<LocationData> locationData;
        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        try {
            new AsyncTask<Void, Void, Void>(){
                @Override
                protected void onPreExecute() {
                    dialog.setMessage("Processing...");
                    dialog.show();
                }
                protected Void doInBackground(Void... params) {
                    Log.d(DEBUGTAG, "2---------------------");
                    ParkingFinder parkingFinder = new ParkingFinder();
                    bulkData.setBulkData(parkingFinder.getParkingArea(coordinate, vehicle));
                    Log.d(DEBUGTAG, "ParkingFinder data size : " + bulkData.getBulkData().size());
                    Log.d(DEBUGTAG, "3---------------------");
                    return null;
                }
                @Override
                protected void onPostExecute(Void aVoid) {
                    dialog.dismiss();
                }
            }.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        locationData = bulkData.getBulkData();
        Log.d(DEBUGTAG, "Size: " + locationData.size());
        for(final LocationData locData : locationData){
            MarkerOptions mOptions = new MarkerOptions();
            mOptions.title(locData.getAddress());
            mOptions.snippet("SELECT");
            mOptions.position(locData.getLocation());
            mOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            mMap.addMarker(mOptions);
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    Toast.makeText(MainActivity.this, marker.getTitle() + " clicked", Toast.LENGTH_LONG).show();
                    return false;
                }
            });
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

                    Toast.makeText(MainActivity.this, "Selected " + marker.getTitle() + " \n Coordinates: " + marker.getPosition().latitude + ", " + marker.getPosition().longitude, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + marker.getPosition().latitude + "," + marker.getPosition().longitude));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 16);
        mMap.animateCamera(yourLocation);
    }
}
