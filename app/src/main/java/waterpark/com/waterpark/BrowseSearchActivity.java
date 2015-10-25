package waterpark.com.waterpark;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class BrowseSearchActivity extends Activity {

    public static final String DEBUGTAG = "DEBUG_VC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_search);

        final RadioButton bicycleButton = (RadioButton)findViewById(R.id.id_rad_bycycle);
        final RadioButton motorcycleButton = (RadioButton)findViewById(R.id.id_rad_motorcycle);
        final RadioButton carButton = (RadioButton)findViewById(R.id.id_rad_car);

        Button buttonSearchLocation = (Button)findViewById(R.id.id_button_search);
        Button buttonCurrentLocation = (Button)findViewById(R.id.id_button_current_location);
        buttonCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int decidedVehicle = 2;
                if(carButton.isChecked())
                    decidedVehicle = 1;
                else if(bicycleButton.isChecked())
                    decidedVehicle = 2;
                else if(motorcycleButton.isChecked())
                    decidedVehicle = 3;

                Log.d(DEBUGTAG, "Vehicle: " + decidedVehicle);
                Intent i = new Intent(BrowseSearchActivity.this, MainActivity.class);
                i.putExtra("searchType", 2);
                i.putExtra("vehicle", decidedVehicle);
                startActivity(i);
            }
        });

        buttonSearchLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Geocoder geocoder = new Geocoder(BrowseSearchActivity.this);
                TextView textView = (TextView)findViewById(R.id.text_search_address);
                double latitude = 43.46364889;
                double longitude = -80.52186743;
                try {
                    List<Address> addresses = geocoder.getFromLocationName(textView.getText().toString(), 1);
                    if(addresses.size() > 0) {
                        latitude= addresses.get(0).getLatitude();
                        longitude= addresses.get(0).getLongitude();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                int decidedVehicle = 2;
                if(carButton.isChecked())
                    decidedVehicle = 1;
                else if(bicycleButton.isChecked())
                    decidedVehicle = 2;
                else if(motorcycleButton.isChecked())
                    decidedVehicle = 3;

                Log.d(DEBUGTAG, "Vehicle: " + decidedVehicle);
                Intent i = new Intent(BrowseSearchActivity.this, MainActivity.class);
                i.putExtra("searchType", 1);
                i.putExtra("vehicle", decidedVehicle);
                i.putExtra("longitude", longitude);
                i.putExtra("latitude", latitude);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_browse_search, menu);
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
    }
}
