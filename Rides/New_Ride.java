package Rides;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.changingactivities.R;

public class New_Ride extends AppCompatActivity {
    String[] allowedGender = {"Mixed", "Male", "Female"};
    String date, time, leavingFrom, goingTo;
    String item = null;
    int passengers, i;

    Button submit;
    EditText dateInput, timeInput, leavingInput, goingInput, passengerInput;

    AutoCompleteTextView Gender_new;

    ArrayAdapter<String> adapterItems;

    private void locking(){
        String s1 = dateInput.getText().toString();
        String s2 = timeInput.getText().toString();
        String s3 = leavingInput.getText().toString();
        String s4 = goingInput.getText().toString();
        String s5 = passengerInput.getText().toString();


        if(s1.equals("")  || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")){
            submit.setEnabled(false);
        }
        else {
            submit.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ride);
        dateInput = findViewById(R.id.dayOf);
        timeInput = findViewById(R.id.timeOf);
        leavingInput = findViewById(R.id.LeavingFrom);
        goingInput = findViewById(R.id.GoingTo);
        passengerInput = findViewById(R.id.numOfPassenger);
        submit.setEnabled(false);

        TextWatcher tex = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { locking(); }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {locking();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                locking();
            }
        };

        dateInput.addTextChangedListener(tex);
        timeInput.addTextChangedListener(tex);
        leavingInput.addTextChangedListener(tex);
        goingInput.addTextChangedListener(tex);
        passengerInput.addTextChangedListener(tex);
        Gender_new = findViewById(R.id.autoGender);

        adapterItems = new ArrayAdapter<>(this, R.layout.list_items, allowedGender);

        Gender_new.setAdapter(adapterItems);

        Gender_new.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();
                i = position;
            }
        });

        submit = findViewById(R.id.Post_Ride);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = dateInput.getText().toString();
                time = timeInput.getText().toString();
                leavingFrom = leavingInput.getText().toString();
                goingTo = goingInput.getText().toString();
                passengers = 0 ;
                try {Integer.parseInt(passengerInput.getText().toString());
                passengers = Integer.parseInt(passengerInput.getText().toString());}
                catch (NumberFormatException e) {                }

                if(date == null || time == null || leavingFrom == null || goingTo == null||
                        passengers == 0){}
                        else { showToast(date + " " + time + " " + leavingFrom + " " + goingTo + " " + item);
//                     method.post(getIntent().getStringExtra("userName"),
                    // getIntent().getStringExtra("Community"),getIntent().getStringExtra("userEmail")
                    // ,date,time,leavingFrom
                    //goingTo, passengers);
                }}
        });
    }

    private void showToast(String text){
        Toast.makeText(New_Ride.this, text, Toast.LENGTH_SHORT).show();
    }
}