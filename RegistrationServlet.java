package test;
import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")

public class RegistrationServlet extends HttpServlet {
	
	
		private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int userId=Integer.parseInt(request.getParameter("id"));
	String userName=request.getParameter("UserName");
		String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    String role=request.getParameter("Role");
	    String  s1=request.getParameter("date");
	    LocalDateTime datetime = LocalDateTime.parse(s1, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

	    Timestamp timestamp = Timestamp.valueOf(datetime);

	    response.setContentType("text/html");
	User s=new User();
	s.setUserId(userId);
	s.setUsername(userName);
	s.setPassword(password);
	s.setEmail(email);
	s.setRole(role);
	s.setS(timestamp);
	
	int result=new RegistrationDao().insert(s);
	PrintWriter pw=response.getWriter();
	if(result>0) {


	pw.println("<html><head></head><body><h1>Student registered Successfully</h1><br><a LoginForm.html>Login</a></body></html>");

	 
	 RequestDispatcher rd = request.getRequestDispatcher("LoginForm.html");
	 
	 rd.include(request, response);
	
	}
	else {

		  RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.html");
		  
		  rd.include(request, response);
		 
	}
	   
	}
	}




