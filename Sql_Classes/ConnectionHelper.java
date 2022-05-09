package Sql_Classes;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class ConnectionHelper {


      Connection con;
    String ip, port, db;

    @SuppressLint("NewApi")
    public static Connection conclass(){
        StrictMode.ThreadPolicy pol = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(pol);
        Connection connection = null;
        String ConnectURL=null;
        try
        {
            Class.forName("com.sourceforge.jtds.jdbc.Driver");
            ConnectURL=setupDBConnection();
            connection = DriverManager.getConnection(ConnectURL);
        }
        catch(Exception exc){
            Log.e("Error :", exc.getMessage());
        }
        return connection;
    }

    public static String setupDBConnection () {
        Map<String, String> env = System.getenv();
        // I used the Environment Variables so that they were private (not online)
        String endpoint = env.get("dbendpoint");

        String user = env.get("user");
        String password = env.get("password");
        return "jdbc:sqlserver://database-1.cbjmpwcdjfmq.us-east-1.rds.amazonaws.com;"
                + "database=DovidDuskis;"
                + "user=admin;"
                + "password=mcon364ab;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
    }


}
