/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ashik
 */
public class BookDaoTest {
    
    public BookDaoTest(String callno, String name, String author, String publisher, int quantity) {
    }

    /**
     * Test of save method, of class BookDao.
     */
    
     private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/library",
            "root",
            "");
    }

    public BookDaoTest createUser(String callno,String name,String author,String publisher,int quantity) throws SQLException
         {
       
            String SQL_INSERT = null;
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_INSERT)) {
            ps.setString(1, callno);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setInt(5, quantity);
            
            ps.executeUpdate();
        }
            return new BookDaoTest(callno,name,author,publisher,quantity);
        
    }
    
    @Test
    public int testSave(String callno,String name,String author,String publisher,int quantity){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,quantity) values(?,?,?,?,?)");
		ps.setString(1,callno);
		ps.setString(2,name);
		ps.setString(3,author);
		ps.setString(4,publisher);
		ps.setInt(5,quantity);
		status=ps.executeUpdate();
		con.close();
	}catch(SQLException e){System.out.println(e);}
	return status;
}

    /**
     * Test of PublisherValidate method, of class BookDao.
     * @param Publisher
     * @return 
     */
    @Test
    public boolean testPublisherValidate( String Publisher)
{
    boolean status = false;
    try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from Publisher where PublisherName = ?"); 
        ps.setString(1, Publisher);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }catch(Exception e){System.out.println(e);}
    return status;
}

    /**
     * Test of AddPublisher method, of class BookDao.
     */
    @Test
    public int testAddPublisher( String Publisher)
    {
        int status= 0;
        try(Connection con = DB.getConnection()) {
		PreparedStatement ps=con.prepareStatement("insert into Publisher(PublisherName) values(?)");
		ps.setString(1,Publisher);
		status=ps.executeUpdate();
                con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
        
    }

    /**
     * Test of SaveBook method, of class BookDao.
     */
    @Test
    public int testSaveBook(String BookN, String AuthorN, String PublisherN, String ShelfN, String RowN, String GenreN) {
            int status= 0;
        try(Connection con = DB.getConnection()) {
		PreparedStatement ps=con.prepareStatement("insert into Books(BookName,Author,Genre,Publisher,Shelf, Row) values(?,?,?,?,?,?)");
		ps.setString(1,BookN);
                ps.setString(2, AuthorN);
                ps.setString(3, GenreN);
                ps.setString(4, PublisherN);
                ps.setString(5, ShelfN);
                ps.setString(6, RowN);
		status=ps.executeUpdate();
                con.close();
	}catch(Exception e){System.out.println(e);}
	return status;    }

    /**
     * Test of Delete method, of class BookDao.
     */
    @Test
    public int testDelete(int BookID)
    {
          int status= 0;
        try(Connection con = DB.getConnection()) {
		PreparedStatement ps=con.prepareStatement("DELETE FROM Books where BookID=?");
		ps.setInt(1,BookID);
		status=ps.executeUpdate();
                con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
        
    }
    
}
