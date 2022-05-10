package Offers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.changingactivities.R;

public class Offers extends AppCompatActivity {
    private Button search;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_create);

        create = findViewById(R.id.New_Offer);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openOffer1();
            }
        });

        search = findViewById(R.id.Search_Offer);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openOffer2();
            }
        });
    }

    private void openOffer1() {
        Intent intent = new Intent(this,
                New_Offer.class);
        String userName = getIntent().getStringExtra("userName");
        intent.putExtra("userName", userName);
//        String email = getIntent().getStringExtra("userEmail");
//        intent.putExtra("userEmail", email);
//        String Community = getIntent().getStringExtra("Community");
//        intent.putExtra("Community", Community);
        startActivity(intent);
    }

    private void openOffer2() {
        Intent intent = new Intent(this,
                Search_Offer.class);
        String userName = getIntent().getStringExtra("userName");
        intent.putExtra("userName", userName);
//        String email = getIntent().getStringExtra("userEmail");
//        intent.putExtra("userEmail", email);
//        String Community = getIntent().getStringExtra("Community");
//        intent.putExtra("Community", Community);
        startActivity(intent);
    }
    private void showToast(String text){
        Toast.makeText(Offers.this, text, Toast.LENGTH_SHORT).show();
    }
}