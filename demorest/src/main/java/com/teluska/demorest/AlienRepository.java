package com.teluska.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienRepository {

	List<Alien> Aliens;
	private final String url = "jdbc:postgresql://localhost/testdb";
    private final String user = "postgres";
    private final String password = "Kamplikar@2";
 
    
	public AlienRepository()
	{
		
		
	      
	       
	}
	
	

	public List<Alien> getAliens() {
		
	
	 
		   Connection conn = null;
		List<Alien> Aliens = new ArrayList();
		 ResultSet rs = null;
		String sqlstmt = "SELECT * FROM ALIEN;";
		Statement stmt = null;
		try {
			
			  try {
		            conn = DriverManager.getConnection(url, user, password);
		            System.out.println("Connected to the PostgreSQL server successfully.");
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }

			stmt = conn.createStatement();
			 rs = stmt.executeQuery( sqlstmt );
			 System.out.println(rs);
		        while ( rs.next() ) {
		           int id = rs.getInt("id");
		           String  name = rs.getString("name");
		           int points  = rs.getInt("points");
		          
		           System.out.println( "ID = " + id );
		           System.out.println( "NAME = " + name );
		           System.out.println( "points = " + points );
		        
		           Alien a= new Alien();
		           a.setId(id);
		           a.setName(name);
		           a.setPoints(points);
		           Aliens.add(a);
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

	        try {
	        	if(rs != null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	if(stmt != null)
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	if(conn != null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return Aliens;
	}
	
	public Alien getAlien(int id)
	{
	
		 Connection conn = null;
		Alien a = new Alien();
		 ResultSet rs = null;
		String sqlstmt = "SELECT * FROM ALIEN WHERE ID='"+id+"';";
		Statement stmt = null;
		try {
			
			  try {
		            conn = DriverManager.getConnection(url, user, password);
		            System.out.println("Connected to the PostgreSQL server successfully.");
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }

			  
			stmt = conn.createStatement();
			 rs = stmt.executeQuery( sqlstmt );
			 System.out.println(rs);
		        while ( rs.next() ) {
		           int id1 = rs.getInt("id");
		           String  name = rs.getString("name");
		           int points  = rs.getInt("points");
		          
		           System.out.println( "ID = " + id1 );
		           System.out.println( "NAME = " + name );
		           System.out.println( "points = " + points );
		        
		        
		           a.setId(id);
		           a.setName(name);
		           a.setPoints(points);
		       
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

	        try {
	        	if(rs != null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	if(stmt != null)
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	if(conn != null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return a;
	}

	public void create(Alien a1) {

		 String url1 = "jdbc:postgresql://localhost/testdb";
	     String user1 = "postgres";
	     String password1 = "Kamplikar@2";
	     
		Connection conn1 = null;
		String sqlstmt = "INSERT INTO ALIEN (ID,NAME,POINTS) VALUES (111,'Ranga1',011);";
		Statement stmt = null;
		try {

			try {
				conn1 = DriverManager.getConnection(url1, user1, password1);
				System.out.println("Connected to the PostgreSQL server successfully.");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			System.out.println(sqlstmt);
			stmt = conn1.createStatement();
			stmt.executeUpdate(sqlstmt);
			//conn1.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {


			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn1 != null)
					conn1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	}
	
	
	
	/*
	 * public static void main(String[] args) { AlienRepository app = new
	 * AlienRepository(); app.getAliens(); }
	 * 
	 */
}
