
/*package test;
import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        // Retrieve form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("Rama".equals(username) && "Rm14".equals(password)) {
            response.sendRedirect("home.jsp");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Login Status</title></head><body>");
            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid username or password. Please try again.</p>");
            out.println("<p><a href=\"login.html\">Back to Login</a></p>");
            out.println("</body></html>");
        }
    }
}*/
 package test;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
    String n=request.getParameter("username");  
	    String p=request.getParameter("password");  
	         
	    
	        ArrayList<User> li=(ArrayList<User>) new LoginD().validate(n, p);
	        if(li.size()==0) {
	        	out.print("Sorry Wrong username or password ...Try Again");
	        	
		        RequestDispatcher rd=request.getRequestDispatcher("LoginForm.html");  
		        rd.include(request,response);  
	        	
	        }
	        else{ 
	        	for(int i=0;i<li.size();i++) {
		    
		    	
		    	out.println("<html><head></head><body><h1>Login Successfull.....</body></html>");
		    	out.println("<html><head></head><body><h1>Go To HomePgage.....<a href=home.html>HOME</a></body></html>");

		    	//RequestDispatcher rd=request.getRequestDispatcher("home.html");  
		       // rd.include(request,response);  

		}
	        	
	        	


	}

	    
	} 	 
	        
	    }  
	





