package com.example.changingactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import Communities.Create_Community;
import Offers.Offers;
import Rides.Rides;
import Sql_Classes.data_From_sql3;

// this is the main hub of the app

public class MainPage extends AppCompatActivity {
    private Button Fool;
    private Button rides;
    private Button offers;
    private Button communities;
    private Button getCommunities;
    private Button Admins;

    public String UserId = "Dovid Duskis";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //        String email = getIntent().getStringExtra("userEmail");
        String Community = getIntent().getStringExtra("Community");


        Admins = findViewById(R.id.Admin_Activity);



        getCommunities = findViewById(R.id.Community_Search);
        getCommunities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open();
            }
        });

        rides = (Button) findViewById(R.id.Rides);
        rides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRides();
            }
        });

        offers = findViewById(R.id.Offers);
        offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openOffers();
            }
        });

        communities = findViewById(R.id.CummintyCreate);
        communities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCommunity();
            }
        });

        if(Community == null || Community ==""){
            offers.setEnabled(false);
            rides.setEnabled(false);
        }else{
            communities.setEnabled(false);
            getCommunities.setEnabled(false);

        }
        boolean isAdmin = getIntent().getBooleanExtra("isAdmin", false);
        if(!isAdmin){
            Admins.setVisibility(View.GONE);
        }
    }

    private void showToast(String text){
        Toast.makeText(MainPage.this, text, Toast.LENGTH_SHORT).show();
    }

    private void putData(Intent i){
        String userName = getIntent().getStringExtra("userName");
        i.putExtra("userName", userName);

//        String email = getIntent().getStringExtra("userEmail");
//        intent.putExtra("userEmail", email);
//        String Community = getIntent().getStringExtra("Community");
//        intent.putExtra("Community", Community);
        startActivity(i);
    }

    private void openRides() {
        Intent intent = new Intent(this,
                Rides.class);
        putData(intent);
    }

    private void open(){
        String community = getIntent().getStringExtra("Community");

        Intent intent = new Intent(this, data_From_sql3.class);
        startActivity(intent);
    }

    private void openOffers() {
        Intent intent = new Intent(this,
                Offers.class);
        putData(intent);
    }
    private void openCommunity(){
        String community = getIntent().getStringExtra("Community");
        Intent intent = new Intent(this,
                    Create_Community.class);
        putData(intent);
    }
}