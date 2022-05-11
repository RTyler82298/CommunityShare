import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBUtils {





    private static String setupDBConnection () {
        return "jdbc:sqlserver://DESKTOP-2TSRUTK\\sqlexpress;"
                + "database=RideShareTest;"
                + "user=admin;"
                + "password=test;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=10;";
    }


    public static String getItemPosts (String searchWord) {
        ResultSet resultSet = null;
        String search = "";
        String query = "SELECT * FROM Items WHERE Description = ?;";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery = connection.prepareStatement(query)){
            prepedQuery.setString(1,searchWord);
            prepedQuery.execute();
            resultSet = prepedQuery.getResultSet();

            while (resultSet.next()) {
                search += "Post Number: \t" + resultSet.getString("ItemID") + "\t Poster: \t" + resultSet.getString("Username")
                 + "Condition: \t" + resultSet.getString("Condition") + "\n";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return search;
    }





    static String loginUser(String Username, String Password) {
        ResultSet resultSet = null;
        String query = "Select * from Users Where UserID = ? and Password = ?";
        try(Connection connection = DriverManager.getConnection(setupDBConnection());
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,Username);
            preparedStatement.setString(2, Password);

            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            resultSet.next();

            if (resultSet.getRow() != 1) {
                return "Error";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
        return "Success";
    }


    static String createUser(String Username, String Password, String Email)  {
        ResultSet resultSet = null;
        String query = "Insert INTO Users (UserID, Password, Email) Values ( ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
        PreparedStatement prepquery = connection.prepareStatement(query)){
            prepquery.setString(1, Username);
            prepquery.setString(2, Password);
            prepquery.setString(3, Email);
            prepquery.execute();
            resultSet = prepquery.getResultSet();
            return "Added User";
        }
        catch (Exception e) {
            e.printStackTrace();

            //TODO make sure this only returns if the Violation of Primary Key Error is thrown
            return "Username Taken";
        }
    }

    public static String getRidePosts ( String searchWord) {
        ResultSet resultSet = null;
        String search = "PostID \t Condition \t Poster \n";
        String query = "SELECT * FROM Rides WHERE Destination = ?;";
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
