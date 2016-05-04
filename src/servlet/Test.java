package servlet;

import java.rmi.ServerError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Леонид on 03.05.2016.
 */

public class Test {
    public  static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
    }
    public static void set(String txt){
        System.out.println(0);
        try(Connection c=getConnection();){
            System.out.println(1);
            PreparedStatement ps= c.prepareStatement("INSERT INTO testtable (name) VALUES (?)");
            System.out.println(2);
            ps.setString(1,txt);
            System.out.println(3);
            ps.executeUpdate();
            System.out.println(4);

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
