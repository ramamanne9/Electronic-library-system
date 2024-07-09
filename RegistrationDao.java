package test;
import javax.servlet.*;




import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationDao {

	
		int k=0;
		
		public int insert(User s) {
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:orcl","system","admin");  
			      
			PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			      ps.setInt(1, s.getUserId());
			      ps.setString(2,s.getUsername());
			      ps.setString(3, s.getPassword());
			      ps.setString(4,s.getEmail() );
			      ps.setString(5,s.getRole());
			      ps.setTimestamp(6, s.getS());
			      
			     k= ps.executeUpdate();
			}
		catch(Exception e){System.out.println(e);}
		return k;
		}
}


