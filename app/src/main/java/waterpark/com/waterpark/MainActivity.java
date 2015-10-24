package waterpark.com.waterpark;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import waterpark.com.waterpark.R;

public class MainActivity extends Activity {

    public static final String DEBUGTAG = "DEBUG_VC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double longitude = 0.0;
        double latitude = 0.0;
        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        try{
            Criteria criteria = new Criteria();
            String bestProvider = lm.getBestProvider(criteria, false);
            Location location = lm.getLastKnownLocation(bestProvider);


            longitude = location.getLongitude();
            latitude = location.getLatitude();
            Log.d(DEBUGTAG, "Longitude " + longitude);
            Log.d(DEBUGTAG, "Latitude " + latitude);
        }catch(Exception ex){
            ex.printStackTrace();
        }


        final GoogleMap mMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

        MarkerOptions mOptions = new MarkerOptions();
        mOptions.title("My place");
        //LatLng coordinate = new LatLng(43.4619415152536, -80.5222363389286);
        LatLng coordinate = new LatLng(latitude, longitude);
        mOptions.position(coordinate);

        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 12);
        mMap.animateCamera(yourLocation);
        mMap.addMarker(mOptions);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions newMarker = new MarkerOptions();
                newMarker.position(latLng);
                newMarker.title("My Marker");
                mMap.addMarker(newMarker);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
