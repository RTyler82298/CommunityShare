package Offers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.changingactivities.R;

// this is to create a post about the offers
public class New_Offer extends AppCompatActivity {

    String[] Qualities = {"Perfect", "Great", "Good", "Ok", "Acceptable", "Broken"};
    int number;
    String nameOfGood, qualityOfItem;
    Button posting;

    EditText numInput, nameInput;
    AutoCompleteTextView quality;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_offer);
        numInput = findViewById(R.id.NumberOfItem);
        nameInput = findViewById(R.id.NameOfItem);

        quality = findViewById(R.id.Quality);

        adapterItems = new ArrayAdapter<>(this, R.layout.list_items, Qualities);

        quality.setAdapter(adapterItems);

        quality.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                qualityOfItem = parent.getItemAtPosition(position).toString();
            }
        });

        posting = findViewById(R.id.OfferPost);
        posting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = getIntent().getStringExtra("userName");
                //String Community = getIntent().getStringExtra("Community");
                //String email = getIntent().getStringExtra("userEmail");

                nameOfGood = nameInput.getText().toString();

                number = 0 ;
                try {Integer.parseInt(numInput.getText().toString());
                    number = Integer.parseInt(numInput.getText().toString());}
                catch (NumberFormatException e){}
                if(qualityOfItem == null || nameOfGood == null||
                        number == 0){}
                else {
                    showToast(nameOfGood + " " + (number + "") + " " + qualityOfItem);
                    showToast("This is being offered by user " + userName);
//                     method.post(getIntent().getStringExtra("userName"),
                    // getIntent().getStringExtra("Community"),getIntent().getStringExtra("userEmail")
                    // ,number, nameOfGood, qualityOfItem);
                }

                /*
                * The data being sent to the server can be defined as
                * username = OfferedBy in the db
                * nameOfGood = NameOfGood
                * qualityOfItem = Quality
                * */
            }
        });
    }

    private void showToast(String text){
        Toast.makeText(New_Offer.this, text, Toast.LENGTH_SHORT).show();
    }
}