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


    public static Map<String,String> getItemPosts (String searchWord) {
        ResultSet resultSet = null;
        Map<String,String> search = new HashMap<>();
        String query = "SELECT * FROM Items WHERE Description = ?;";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery = connection.prepareStatement(query)){
            prepedQuery.setString(1,searchWord);
            prepedQuery.execute();
            resultSet = prepedQuery.getResultSet();

            while (resultSet.next()) {
                search.put(resultSet.getString("UserName"), resultSet.getString("Condition") + resultSet.getString("ItemID"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return search;
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
