package com.example.changingactivities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static String setupDBConnection () {
        return "jdbc:sqlserver://;"
                + "database=DovidDuskis;"
                + "user=admin;"
                + "password=*********;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
    }

    public static List<Map<String, String>> comun(){
        ResultSet resultSet = null;
        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();

        String query = "SELECT * FROM Communities";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery = connection.prepareStatement(query)){

            Statement state = connection.createStatement();
            resultSet = state.executeQuery(query);

            while (resultSet.next()) {
                Map<String, String> aa = new HashMap<String, String>();
                aa.put("Communities", resultSet.getString("FirstName"));
                //search += "\t" + resultSet.getInt("itemID") + "\t" + resultSet.getString("Condition") + "\t" + resultSet.getString("UserName") + "\n";
                data.add(aa);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }


    public static String getPosts (String searchWord) {

        ResultSet resultSet = null;
        String search = "PostID \t Condition \t Poster \n";
        String query = "SELECT * FROM Items WHERE Description = ?;";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery = connection.prepareStatement(query)){
            prepedQuery.setString(1,searchWord);
            prepedQuery.execute();
            resultSet = prepedQuery.getResultSet();

            while (resultSet.next()) {
                search += "\t" + resultSet.getInt("itemID") + "\t" + resultSet.getString("Condition") + "\t" + resultSet.getString("UserName") + "\n";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return search;
    }



    public static String getPosterUsername (int postID) {
        ResultSet resultSet = null;
        String query ="SELECT * FROM Items WHERE itemID = ?;";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery = connection.prepareStatement(query)){
            prepedQuery.setInt(1,postID);
            prepedQuery.execute();
            resultSet = prepedQuery.getResultSet();
            resultSet.next();
            return resultSet.getString("UserName");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;




    }




    public static String getPosterEmail (String username) {
        ResultSet resultSet = null;
        String query ="SELECT * FROM Users WHERE UserID = ?;";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery =connection.prepareStatement(query)){
            prepedQuery.setString(1,username);
            prepedQuery.execute();
            resultSet = prepedQuery.getResultSet();
            resultSet.next();
            return resultSet.getString("Email");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
        //IF the program gets to here something has gone very wrong.
    }
}
