package www.a3w.persone;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import www.a3w.R;


public class PersoneActivity extends AppCompatActivity implements View.OnClickListener, PersoneView, DatePickerDialog.OnDateSetListener {
    private Button mCalendar;
    private Button mType;
    private Button mAdd;
    private EditText mName;
    private Calendar mCalendarField = null;
    private int mTypeField = -1;
    private PersonePresenter mPersonePresenter;
    final String[] sGirlType = {"Жена", "Дочь", "Мама", "Колега"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persone);

        mCalendar = (Button) findViewById(R.id.button_home_calendar);
        mType = (Button) findViewById(R.id.button_home_type);
        mAdd = (Button) findViewById(R.id.button_toolbar_add);
        mName = (EditText) findViewById(R.id.edit_text_home_name);

        mCalendar.setOnClickListener(this);
        mType.setOnClickListener(this);
        mAdd.setOnClickListener(this);

        mPersonePresenter = new PersonPresenterImpl(this,this);
        mPersonePresenter.getPersones();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_toolbar_add: {
                mPersonePresenter.checkPersone(mName.getText().toString(), mTypeField, mCalendarField);
                break;
            }
            case R.id.button_home_calendar: {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                Dialog picker = new DatePickerDialog(this, this,
                        year, month, day);
                picker.setTitle(getResources().getString(R.string.birthday));
                picker.show();
                break;
            }
            case R.id.button_home_type: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Выберите кем приходится вам девушка")
                        .setItems(sGirlType, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mTypeField = which;
                            }
                        });
                builder.create();
                builder.show();
                break;
            }
        }
    }

    @Override
    public void setNameError() {
        mName.setError("Введите имя");
    }

    @Override
    public void setTypeError() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Выберете кто для вас человек", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void setDateError() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Выберете день рождения", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mCalendarField = new GregorianCalendar(year, month, dayOfMonth);
    }
}
