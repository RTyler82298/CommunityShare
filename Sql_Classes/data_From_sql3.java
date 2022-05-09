package Sql_Classes;

import static com.android.volley.Request.*;
import static com.android.volley.Request.Method.*;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.changingactivities.ListItem;
import com.example.changingactivities.R;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.NameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.UrlEncodedFormEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class data_From_sql3 extends AppCompatActivity {
    List<Map<String,String>> myDataList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_from_sql3);

    }

    SimpleAdapter ad;

    public void trying(View v) {
        
// throws UnsupportedEncodingException
//        String URL = "http://localhost:8080/demo2_war_exploded";
//        HttpPost post = new HttpPost(URL);
//
//        RequestQueue rq = Volley.newRequestQueue(this);
//
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//
//        StringRequest stringRequest;
//        stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                showToast("Response from server; " + response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                showToast("Error: " + error.getMessage());
//            }
//
//    });
//
//        rq.add(stringRequest);


//        Connection connection;
//        ResultSet resultSet = null;
//        try {
//            showToast("hello there general");
//            connection = ConnectionHelper.conclass();
//            showToast("konobi");
//            if(connection != null){
//                String qu = "SELECT TOP 10 StudentId, FirstName, LastName FROM Students";
//                Statement state = connection.createStatement();
//                resultSet = state.executeQuery(qu);
//                showToast("Hello");
//
//
//                // Print results from select statement
//                while (resultSet.next()) {
//                    //Map<String,String> aa = new HashMap<>();
//                    //aa.put("CommunityName", resultSet.getString("FirstName"));
//                    showToast(resultSet.getString("FirstName"));
//                    //myDataList.add(aa);
//                }
//                connection.close();
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        ListView listView = (ListView) findViewById(R.id.listView);

        String[] Fromw = {"CommunityName"};
        int[] tow = {R.id.CommunityName};

        ad = new SimpleAdapter(this, myDataList,
                R.layout.community, Fromw, tow);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(myDataList.get(i).get("CommunityName"));
            }
        });
        listView.setAdapter(ad);
    }


    public void GetData3(View v){
        ListView listView = (ListView) findViewById(R.id.listView);

        ListItem myData = new ListItem();
        myDataList = myData.getlist3();

        String[] Fromw = {"CommunityName"};
        int[] tow = {R.id.CommunityName};

        ad = new SimpleAdapter(this, myDataList,
                R.layout.community, Fromw, tow);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(myDataList.get(i).get("CommunityName"));
            }
        });
        listView.setAdapter(ad);
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}