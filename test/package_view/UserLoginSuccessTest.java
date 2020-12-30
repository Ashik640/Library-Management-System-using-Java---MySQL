/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import package_controller.DB;
import static package_view.UserLoginSuccess.GetEmail;
import static package_view.UserLoginSuccess.GetName;
import static package_view.UserLoginSuccess.GetRegDate;
import static package_view.UserLoginSuccess.GetUserID;

/**
 *
 * @author Ashik
 */
public class UserLoginSuccessTest {
    
    public UserLoginSuccessTest() {
    }

    /**
     * Test of main method, of class UserLoginSuccess.
     */
    
   /*  private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mckoi://localhost/",
            "admin_user",
            "aupass00");
    }

    public User createUser(String userId, String firstName, String lastName)
        throws DAOException {
        try {
            String SQL_INSERT = null;
            try (PreparedStatement ps = getConnection().prepareStatement(SQL_INSERT)) {
                ps.setString(1, userId);
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                ps.executeUpdate();
            }
            return new User(userId, firstName, lastName);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }
} */
    
    @Test
    public void testMain() {
        
        
        String[] args = null;
        
        //String User=args[0];
        //String Pass=args[1];
        String User="Deco";
       String Pass="1234";
        try{
			Connection Con;
                        Con = DB.getConnection();
			PreparedStatement ps;
                        ps = Con.prepareStatement("select * from Users where UserName=? and UserPass=?");
			ps.setString(1,User);
			ps.setString(2,Pass);
			ResultSet rs;
                          rs = ps.executeQuery();
            boolean status = rs.next();
            GetName = User;
            GetRegDate = rs.getString("RegDate");
            GetEmail = rs.getString("Email");
            GetUserID = rs.getString("UserID");
            Con.close();
        
       
         }catch(Exception f){System.out.println(f);}
        
        
        
    }
    
}
