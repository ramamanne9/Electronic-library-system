package test;



	import java.io.IOException;

	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.PrintWriter;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
		@WebServlet("/admin")
	public class AdminLoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			          
		    String n=request.getParameter("username");  
			    String p=request.getParameter("password");  
			  
			         
			    
			       boolean li= new AdminDao().validate(n, p);
			        if(li==true) {
			        	out.print("Sorry username or password error");  
				        RequestDispatcher rd=request.getRequestDispatcher("BookDetails.html.html");  
				        rd.include(request,response);  
			        	
			        }
			        else{ 
			        	
				    
				    	out.println("<html><head><style</head><body><h1>Admin registered Successfully</h1><a href=adminlogin.html>Login</a></body></html>");
				}

			        }
			}
			






