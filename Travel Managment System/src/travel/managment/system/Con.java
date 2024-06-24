package travel.managment.system;
import java.sql.*; 

public class Con {
  Connection c;
  Statement s;
    Con() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagmentsystem","your_databse_username","your_databse_password" );
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
