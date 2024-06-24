package travel.managment.system;
import java.sql.*; 

public class Con {
  Connection c;
  Statement s;
    Con() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagmentsystem","root","Goldy45@" );
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}