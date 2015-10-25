package waterpark.com.waterpark;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Vishal on 25/10/2015.
 */
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    TextView dateTextView;

    public DateDialog(View view){
        dateTextView = (TextView)view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return(new DatePickerDialog(getActivity(), this, year, month, day));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String date = year + "-" + (monthOfYear+1) + "-" + dayOfMonth;
        dateTextView.setText(date);
    }
}
