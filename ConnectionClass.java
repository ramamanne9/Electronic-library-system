package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
public static Connection con;
	public static Connection getCon() {
		try {
			System.out.println("Connection Class");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","admin");
System.out.println("Connection Name "+con);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
}
