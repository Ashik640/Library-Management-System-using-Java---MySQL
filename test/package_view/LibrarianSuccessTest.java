/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;
import static org.junit.Assert.*;
import package_controller.DB;
import static package_view.LibrarianSuccess.Email;
import static package_view.LibrarianSuccess.LibrarianID;
import static package_view.LibrarianSuccess.Name;

/**
 *
 * @author Ashik
 */
public class LibrarianSuccessTest {
    
    public LibrarianSuccessTest() {
    }

    /**
     * Test of GetLibrarianLogin method, of class LibrarianSuccess.
     */
    @Test
    public void testGetLibrarianLogin() {
        String[] args = null;
        
        String User="Zero";
        String Pass="9876";
        
       // String User=args[0];
       // String Pass=args[1];
        try{
			Connection Con;
                        Con = DB.getConnection();
			PreparedStatement ps;
                        ps = Con.prepareStatement("select * from Librarian where UserName=? and Password=?");
			ps.setString(1,User);
			ps.setString(2,Pass);
			ResultSet rs;
                          rs = ps.executeQuery();
            boolean status = rs.next();
            Name=rs.getString("FullName");
            LibrarianID = rs.getString("LibrarianID");
            Email = rs.getString("Email");
            System.out.println(Name+" "+LibrarianID+" "+Email);
            Con.close();
        
       
         }catch(Exception f){System.out.println(f);}
        
    }
    
}
