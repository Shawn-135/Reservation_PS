package sg.edu.rp.c346.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etTelephone;
    EditText etSize;
    EditText etDay;
    EditText etTime;
    CheckBox checkBox;
    Button btReserve;
    Button btReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etTelephone = findViewById(R.id.editTextTelephone);
        etSize = findViewById(R.id.editTextSize);
        etDay = findViewById(R.id.editTextDay);
        etTime = findViewById(R.id.editTextTime);
        checkBox = findViewById(R.id.checkBox);
        btReserve = findViewById(R.id.buttonReserve);
        btReset = findViewById(R.id.buttonReset);

        btReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String isSmoke = "";
                if (checkBox.isChecked()) {
                    isSmoke = "smoking";
                } else {
                    isSmoke = "non-smoking";
                }

                Toast.makeText(MainActivity.this,
                        "Hi, " + etName.getText().toString() + ", you have booked a "
                                + etSize.getText().toString() + " person(s) "
                                + isSmoke + " table on "
                                + etDay + "/" + "/" + " at "
                                + etTime + ". Your phone number is "
                                + etTelephone.getText().toString() + ".",
                        Toast.LENGTH_LONG).show();
            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etTelephone.setText("");
                etSize.setText("");
                checkBox.setChecked(false);
            }
        });

        etDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        etDay.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, 2020, 5, 31);
                myDateDialog.show();

            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etTime.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, 20, 00, false);

                myTimeDialog.show();
            }
        });
    }
}

