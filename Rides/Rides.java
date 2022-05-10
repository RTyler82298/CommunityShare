package Rides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.changingactivities.R;

public class Rides extends AppCompatActivity {
    private Button search;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides);

        search = findViewById(R.id.RideSearcher);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRides2();
            }
        });

        create = findViewById(R.id.RideCreator);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRides1();
            }
        });
    }

    private void openRides1() {
        Intent intent = new Intent(this,
                New_Ride.class);
        String userName = getIntent().getStringExtra("userName");
        intent.putExtra("userName", userName);
//        String email = getIntent().getStringExtra("userEmail");
//        intent.putExtra("userEmail", email);
//        String Community = getIntent().getStringExtra("Community");
//        intent.putExtra("Community", Community);
        startActivity(intent);
    }

    private void openRides2() {
        Intent intent = new Intent(this,
                Search_Ride.class);
        String userName = getIntent().getStringExtra("userName");
        intent.putExtra("userName", userName);
//        String email = getIntent().getStringExtra("userEmail");
//        intent.putExtra("userEmail", email);
//        String Community = getIntent().getStringExtra("Community");
//        intent.putExtra("Community", Community);
        startActivity(intent);
    }
}