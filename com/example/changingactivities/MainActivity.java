package com.example.changingactivities;


import android.view.Menu;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.Executors;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

// this is the login/create account page

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private String userName, password, email;

    EditText userInput, passwordInput;

    Map<String, String> ola;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = findViewById(R.id.User_Id);

        button = (Button) findViewById(R.id.log_in_button);

        button.setEnabled(false);


        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                locking();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                locking();
            }

            @Override
            public void afterTextChanged(Editable editable) {
               locking();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                userName =  userInput.getText().toString();
                //password = passwordInput.getText().toString();

                openActivity2();
            }
        });

        button2 = findViewById(R.id.Create_Account_Button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity();
            }
        });
    }

    private void locking(){
        String s1 = userInput.getText().toString();
        //String s2 = et2.getText().toString();

        if(s1.equals("") /*|| s2.equals("")*/){
            button.setEnabled(false);
        }
        else {
            button.setEnabled(true);
        }
    }

    private void openActivity() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    private void openActivity2(/*String s*/) {
            Intent intent = new Intent(this, MainPage.class);
            String Community = null;
            boolean isAdmin =false;


//            showToast(DBUtils.getPosts("Hammer"));

            intent.putExtra("userName", userName);
            intent.putExtra("isAdmin", isAdmin);
            // it will check to see if the user is in a community
//          intent.putExtra("userEmail", email);
          intent.putExtra("Community", Community);
            // maybe we should save the community so we'll see intent.putExtra("userName", userName);

            startActivity(intent);
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}