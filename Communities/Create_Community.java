package Communities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.changingactivities.R;

public class Create_Community extends AppCompatActivity {
    Button button;
    EditText communityInput;
    String community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_community);

        button = findViewById(R.id.button);
        communityInput = findViewById(R.id.NameOfCommunity);
        button.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                community = communityInput.getText().toString();
                showToast(community);

            }
        });
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
        communityInput.addTextChangedListener(tex);
    }

    private void locking(){
        String s1 = communityInput.getText().toString();
        //String s2 = et2.getText().toString();

        if(s1.equals("") /*|| s2.equals("")*/){
            button.setEnabled(false);
        }
        else {
            button.setEnabled(true);
        }
    }
    private void showToast(String text){
        Toast.makeText(Create_Community.this, text, Toast.LENGTH_SHORT).show();
    }
}