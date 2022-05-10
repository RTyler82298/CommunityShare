package com.example.changingactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {
    Button create;
    String userName, password, email;
    EditText userInput, passwordInput, emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        userInput = findViewById(R.id.User_Name_Create);
        passwordInput = findViewById(R.id.Password_Create);
        emailInput = findViewById(R.id.Email);

        create = findViewById(R.id.Create_account);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = userInput.getText().toString();
                password = passwordInput.getText().toString();
                email = emailInput.getText().toString();
                //this is what should be sent to the server
                showToast(userName + "  " + password + "  " + email);
            }
        });
    }

    private void showToast(String text){
        Toast.makeText(CreateAccount.this, text, Toast.LENGTH_SHORT).show();
    }
}