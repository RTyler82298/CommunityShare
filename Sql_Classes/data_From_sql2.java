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

public class data_From_sql2 extends AppCompatActivity {
    List<Map<String,String>> myDataList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_from_sql2);

    }

    SimpleAdapter ad;
    public void GetData2(View v){
        ListView listView = (ListView) findViewById(R.id.listview2);

        String userName = getIntent().getStringExtra("userName");
//        String email = getIntent().getStringExtra("userEmail");
//        String Community = getIntent().getStringExtra("Community");

        String data = getIntent().getStringExtra("Data");


        ListItem myData = new ListItem();
        myDataList = myData.getlist2();

        String[] Fromw = {"Offered_by", "GoingTo", "LeavingFrom","LeavingDate","LeavingTime","numOfPassenger", "email"};
        int[] tow = {R.id.Offered_by, R.id.GoingTo, R.id.LeavingFrom, R.id.LeavingDate,R.id.LeavingTime
        ,R.id.numOfPassenger};

        ad = new SimpleAdapter(data_From_sql2.this, myDataList,
                R.layout.getting_ride, Fromw, tow);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(myDataList.get(i).get("Offered_by") + " " + myDataList.get(i).get("GoingTo")+
                        " " + myDataList.get(i).get("LeavingFrom") + " " + myDataList.get(i).get("email")
                + " " + userName);

                //Mail.sendMail(myDataList.get(i).get("email"), (myDataList.get(i).get("GoingTo")+
                //                        " " + myDataList.get(i).get("LeavingFrom")),
                //                        userName, email, myDataList.get(i).get("Offered_by"))
            }
        });
        listView.setAdapter(ad);
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}