package test;

	import java.sql.Connection;

	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	public class LoginD {
		static List<User> li;
		public static List<User> validate(String name, String password) {
			
	
			
			li= new ArrayList<User>();
			try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:orcl","system","admin");  
			      
			PreparedStatement ps=con.prepareStatement(  
			"select * from Users where USERNAME=? and PASSWORD=?");  
			ps.setString(1,name);  
			ps.setString(2,password); 
					      
			ResultSet rs=ps.executeQuery();  
			 
			if(rs.next()) {
				User u=new User();
				/*
				 * ps.setInt(1, u.getUserId()); ps.setString(2,u.getUsername()); ps.setString(3,
				 * u.getPassword()); ps.setString(4,u.getEmail() ); ps.setString(5,u.getRole());
				 * ps.setTimestamp(6, u.getS());
				 */
				
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setRole(rs.getString(5));
				u.setS(rs.getTimestamp(6));
			      li.add(u);
			}
			
			          
			}catch(Exception e){System.out.println(e);}  
			
			return li;
		}

		
				}
			
		




