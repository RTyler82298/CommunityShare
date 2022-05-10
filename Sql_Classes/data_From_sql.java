package Sql_Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.changingactivities.ListItem;
import com.example.changingactivities.R;

import java.util.List;
import java.util.Map;

public class data_From_sql extends AppCompatActivity {
    List<Map<String,String>> myDataList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_from_sql);
    }

    SimpleAdapter ad;
    public void GetData(View v){
        ListView listView = (ListView) findViewById(R.id.listView);

        com.example.changingactivities.ListItem myData = new ListItem();
        myDataList = myData.getlist();

        String data = getIntent().getStringExtra("Data");

        String[] Fromw = {"Offered_by", "NameOfGood", "Quality3", "Email" };
        int[] tow = {R.id.Offered_by, R.id.NameOfGood, R.id.Quality3};

        ad = new SimpleAdapter(data_From_sql.this, myDataList,
                R.layout.how_list_work, Fromw, tow);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(myDataList.get(i).get("Offered_by") +
                        " " + myDataList.get(i).get("NameOfGood")+
                        " " + myDataList.get(i).get("Quality3")+
                        " " + myDataList.get(i).get("Email"));

                //Mail.sendMail(myDataList.get(i).get("Email"), myDataList.get(i).get("NameOfGood"),
                //                        userName, email, myDataList.get(i).get("Offered_by"))
            }
        });
        listView.setAdapter(ad);
    }


    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}