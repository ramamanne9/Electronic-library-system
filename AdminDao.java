package test;



	import java.sql.Connection;

	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	public class AdminDao {
		
				static List<Admin> li;
				public  boolean validate(String name, String password) {
					
			  
					li= new ArrayList<Admin>();
					try{  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:orcl","system","admin");  
					      
					PreparedStatement ps=con.prepareStatement(  
					"select * from admin where username=? and password=?");  
					ps.setString(1,name);  
					ps.setString(2,password); 
							      
					ResultSet rs=ps.executeQuery();  
				
					if(rs.next()) 
						return true;
					
					        
					}catch(Exception e){System.out.println(e);}
					return false;  
					
					
		}
	}


