package Rides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.changingactivities.R;
import Sql_Classes.data_From_sql2;

public class Search_Ride extends AppCompatActivity {
    String[] allowedGender = {"Mixed", "Male", "Female"};
    String date, time, leavingFrom, goingTo;
    String item = null;
    int passengers;

    Button submit;
    EditText dateInput, timeInput, leavingInput, goingInput, passengerInput;

    AutoCompleteTextView Gender_new;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ride);

        dateInput = findViewById(R.id.DateNeeded);
        timeInput = findViewById(R.id.TimeNeeded);
        leavingInput = findViewById(R.id.LeavingFrom2);
        goingInput = findViewById(R.id.GoingTo2);
        passengerInput = findViewById(R.id.numOfPassenger2);

        Gender_new = findViewById(R.id.autoGender);

        adapterItems = new ArrayAdapter<>(this, R.layout.list_items, allowedGender);

        Gender_new.setAdapter(adapterItems);

        Gender_new.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }
        });

        submit = findViewById(R.id.Search_Ride);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = dateInput.getText().toString();
                time = timeInput.getText().toString();
                leavingFrom = leavingInput.getText().toString();
                goingTo = goingInput.getText().toString();
//
//                showToast(date + " " + time + " " + leavingFrom + " " + goingTo  + " " + item);

                passengers = 0 ;
                try {Integer.parseInt(passengerInput.getText().toString());
                    passengers = Integer.parseInt(passengerInput.getText().toString());}
                catch (NumberFormatException e) {                }

                if(date == null || time == null || leavingFrom == null || goingTo == null||
                        passengers == 0){showToast("You have not entered all the data needed");}
                else { showToast(date + " " + time + " " + leavingFrom + " " + goingTo + " " + item);
                    String[] data = new String[]{date,time,leavingFrom, goingTo, passengers+""};
                    open(data);
                }}
        });

    }

    private void showToast(String text){
        Toast.makeText(Search_Ride.this, text, Toast.LENGTH_SHORT).show();
    }

    private void open(String[] data) {
        Intent intent = new Intent(this,
                data_From_sql2.class);
        String userName = getIntent().getStringExtra("userName");
//        String email = getIntent().getStringExtra("userEmail");
//        String Community = getIntent().getStringExtra("Community");
        intent.putExtra("Data", data);
//        intent.putExtra("userEmail", email);
        intent.putExtra("userName", userName);
//        intent.putExtra("Community", Community);
        startActivity(intent);
    }
}
