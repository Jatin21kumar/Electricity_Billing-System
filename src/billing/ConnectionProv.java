package billing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionProv {
    //Register the driver class
    Connection con;
    Statement stmt;
    public ConnectionProv()
    {
        // creating the connection
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_system", "root", "jatin");
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // creating statement

    }
}
