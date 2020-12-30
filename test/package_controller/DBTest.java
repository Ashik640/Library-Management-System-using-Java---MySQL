/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ashik
 */
public class DBTest {
    
    public DBTest() {
    }

    /**
     * Test of getConnection method, of class DB.
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetConnection() throws SQLException {
        
        Connection con=null;
		try{
                            Properties props = new Properties(); 
    props.put("user", "root");         
    props.put("password", "");
    props.put("useUnicode", "true");
    props.put("useServerPrepStmts", "false"); // use client-side prepared statement
    props.put("characterEncoding", "UTF-8"); // ensure charset is utf8 here

			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library",props);
		}catch(ClassNotFoundException | SQLException e){System.out.println(e);}
	}
        
        
    }
    

