package www.a3w;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mCalendar;
    private Button mType;
    private Button mAdd;
    private EditText mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mCalendar = (Button) findViewById(R.id.button_home_calendar);
        mType = (Button) findViewById(R.id.button_home_type);
        mAdd = (Button) findViewById(R.id.button_home_add);
        mName = (EditText) findViewById(R.id.edit_text_home_name);

        mCalendar.setOnClickListener(this);
        mType.setOnClickListener(this);
        mAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_home_add: {

                break;
            }
            case R.id.button_home_calendar: {
                DialogFragment dateDialog = new DatePicker();
                dateDialog.show(getFragmentManager(),"tag");
                break;
            }
            case R.id.button_home_type: {
                break;
            }
        }
    }
}
