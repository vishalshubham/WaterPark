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
import android.widget.TextView;
import android.widget.Toast;

public class PostDetailsActivity extends Activity {

    public static final String DEBUGTAG = "DEBUG_VC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        Button buttonNext = (Button)findViewById(R.id.id_button_next);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textName = (TextView)findViewById(R.id.text_name);
                TextView textAddr = (TextView)findViewById(R.id.text_address);
                TextView textEmail = (TextView)findViewById(R.id.text_email);
                TextView textPhone = (TextView)findViewById(R.id.text_phone);

                if(textName.getText().length()==0 || textAddr.getText().length()==0 || textEmail.getText().length()==0 || textPhone.getText().length()==0){
                    Toast.makeText(PostDetailsActivity.this, "Mandatory fields blank", Toast.LENGTH_LONG ).show();
                }
                else{
                    Log.d(DEBUGTAG, "Starting PostSearchActivity");
                    Intent i = new Intent(PostDetailsActivity.this, PostSearchActivity.class);
                    i.putExtra("name", textName.getText());
                    i.putExtra("addr", textAddr.getText());
                    i.putExtra("email", textEmail.getText());
                    i.putExtra("phone", textPhone.getText());
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post_details, menu);
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
