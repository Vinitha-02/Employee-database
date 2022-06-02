package loginandlogout;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class login extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");

		String empname= req.getParameter("username");
		String emppass= req.getParameter("password");
		PrintWriter out= res.getWriter();
database d= new database();
		
				try {
					if(d.validate(empname, emppass)) {


					   HttpSession session=req.getSession();  
					 session.setAttribute("Username",empname); 
					// out.println("Welcome " +empname);
					    res.sendRedirect("profile");

						}else {
							
						out.println("Please enter the correct UserName or password");
						RequestDispatcher rd = req.getRequestDispatcher("Indexhtml.html");
						rd.include(req, res);
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
		       

}}