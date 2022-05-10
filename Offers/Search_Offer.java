package Offers;

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

import Sql_Classes.data_From_sql;

public class Search_Offer extends AppCompatActivity {
    String[] Qualities = {"Perfect", "Great", "Good", "Ok", "Acceptable", "Broken"};
    int number;
    String nameOfGood, item;
    Button posting;

    EditText numInput, nameInput;
    AutoCompleteTextView quality;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_offer);

        numInput = findViewById(R.id.NumberOfItem2);
        nameInput = findViewById(R.id.NameOfItem2);

        quality = findViewById(R.id.Quality2);

        adapterItems = new ArrayAdapter<>(this, R.layout.list_items, Qualities);

        quality.setAdapter(adapterItems);

        quality.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }
        });

        posting = findViewById(R.id.OfferSearch);
        posting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameOfGood = nameInput.getText().toString();

                number = 0 ;
                try {Integer.parseInt(numInput.getText().toString());
                    number = Integer.parseInt(numInput.getText().toString());}
                catch (NumberFormatException e){}
                if(item == null || nameOfGood == null||
                        number == 0){}
                else {
                    showToast(nameOfGood + " " + (number + "") + " " + item);
                    String[] data = {nameOfGood, (number + ""), item};
                    open();
                    open(data);
                }


            }
        });
    }

    private void open(){
        Intent intent = new Intent(this, data_From_sql.class);
        String userName = getIntent().getStringExtra("userName");
//        String email = getIntent().getStringExtra("userEmail");
//        String Community = getIntent().getStringExtra("Community");
//        intent.putExtra("userEmail", email);
        intent.putExtra("userName", userName);
//        intent.putExtra("Community", Community);
        startActivity(intent);
    }

    private void open(String[] data){
        Intent intent = new Intent(this, data_From_sql.class);
        String userName = getIntent().getStringExtra("userName");
//        String email = getIntent().getStringExtra("userEmail");
//        String Community = getIntent().getStringExtra("Community");
//        intent.putExtra("userEmail", email);
        intent.putExtra("userName", userName);
//        intent.putExtra("Community", Community);
        intent.putExtra("Data", data);
        startActivity(intent);
    }

    public void showToast(String text){
        Toast.makeText(Search_Offer.this, text, Toast.LENGTH_SHORT).show();
    }
}