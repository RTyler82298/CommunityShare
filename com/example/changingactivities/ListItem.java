package com.example.changingactivities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItem {

    // hopefully in the future it will be done through a sql server
    public List<Map<String, String>> getlist() {
        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();

        for (int i = 0; i < 50; i++) {
            Map<String, String> aa = new HashMap<String, String>();
            aa.put("Offered_by", "dave " + i);
            aa.put("NameOfGood", "hammer " + i);
            aa.put("Quality3", "good " + i);
            aa.put("Email", "e" + i);
            aa.put("Condition", "good " + i);

            data.add(aa);
        }
        return data;
    }

    public List<Map<String, String>> getlist2() {
        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();

        for (int i = 0; i < 50; i++) {
            Map<String, String> aa = new HashMap<String, String>();
            aa.put("Offered_by", "dave " + i);
            aa.put("GoingTo", "a " + i);
            aa.put("NameOfGood", "b " + i);
            aa.put("LeavingFrom", "c " + i);
            aa.put("LeavingDate", "d" + i);
            aa.put("LeavingTime", "e" + i);
            aa.put("numOfPassenger", "f" + i);
            aa.put("email", "@gmail");
            data.add(aa);
        }
        return data;
    }

    public List<Map<String, String>> getlist3() {

        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();

        for (int i = 0; i < 50; i++) {
            Map<String, String> aa = new HashMap<String, String>();
            aa.put("CommunityName", "hola "+ i);
            data.add(aa);
        }
        return data;

//        return DBUtils.comun();
    }
}
