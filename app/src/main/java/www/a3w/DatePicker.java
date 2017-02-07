package www.a3w;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import java.util.Calendar;

/**
 * Created by sergej on 06.02.17.
 */

public class DatePicker extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        Dialog picker = new DatePickerDialog(getActivity(), this,
                year, month, day);
        picker.setTitle(getResources().getString(R.string.birthday));
        return picker;
    }
}
