import javax.xml.registry.infomodel.EmailAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetPosterInfo {

    public static String getPosterEmail (String username) {
        String connectionUrl = // TODO create local database to test properly
                "jdbc:sqlserver:"
                        + "database=;"
                        + "user=;"
                        + "password=;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        ResultSet resultSet = null;
        String query ="SELECT * FROM Users WHERE UserName = ?;";
        try (Connection connection = DriverManager.getConnection(connectionUrl);
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
