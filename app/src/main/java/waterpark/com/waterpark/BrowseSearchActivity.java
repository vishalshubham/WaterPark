package waterpark.com.waterpark;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class BrowseSearchActivity extends Activity {

    public static final String DEBUGTAG = "DEBUG_VC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_search);

        final RadioButton bicycleButton = (RadioButton)findViewById(R.id.id_rad_bycycle);
        final RadioButton motorcycleButton = (RadioButton)findViewById(R.id.id_rad_motorcycle);
        final RadioButton carButton = (RadioButton)findViewById(R.id.id_rad_car);

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
                i.putExtra("vehicle", decidedVehicle);
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
