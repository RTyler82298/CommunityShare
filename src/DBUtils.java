import java.sql.*;

public class DBUtils {




    private static String setupDBConnection () {
        return "jdbc:sqlserver:DESKTOP-2TSRUTK\\SQLEXPRESS;"
                + "database=RideShareTest;"
                + "user=DESKTOP-2TSRUTK\\rdsty;"
                + "password=;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
    }


    public static ResultSet getPosts ( String searchWord) {

        ResultSet resultSet = null;
        String query = "SELECT * FROM Posts WHERE Description = ?;";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery =connection.prepareStatement(query)){
            prepedQuery.setString(1,searchWord);
            prepedQuery.execute();
            resultSet = prepedQuery.getResultSet();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }



    public static String getPosterUsername (String postID) {
        ResultSet resultSet = null;
        String query ="SELECT * FROM Posts WHERE ItemsID = ?;";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery =connection.prepareStatement(query)){
            prepedQuery.setString(1,postID);
            prepedQuery.execute();
            resultSet = prepedQuery.getResultSet();
            return resultSet.getString("UserName");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;




    }




    public static String getPosterEmail (String username) {
        ResultSet resultSet = null;
        String query ="SELECT * FROM Users WHERE UserName = ?;";
        try (Connection connection = DriverManager.getConnection(setupDBConnection());
             PreparedStatement prepedQuery =connection.prepareStatement(query)){
            prepedQuery.setString(1,username);
            prepedQuery.execute();
            resultSet = prepedQuery.getResultSet();
            return resultSet.getString("Email");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
        //IF the program gets to here something has gone very wrong.
    }
}
