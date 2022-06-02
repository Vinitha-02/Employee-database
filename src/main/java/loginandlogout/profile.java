package loginandlogout;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class profile extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        res.setContentType("text/html");
	        

	        PrintWriter pw=res.getWriter();      
	        Connection c=null;
	       PreparedStatement s=null;
	        ResultSet r=null;
	        try {
	        	req.getRequestDispatcher("link.html").include(req, res);   
	        	HttpSession session = req.getSession(false);  
	        	if(session!=null) {
	        String user=	(String) session.getAttribute("Username");
	           Class.forName("com.mysql.jdbc.Driver");
	           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
	            if(user.equals("Admin")) {
	            	
	            	Statement st= c.createStatement();   
	                 r = st.executeQuery("select * from company.employee");
	                 pw.println("Welcome Admin and Employee detail are: ");
	                 while (r.next()) {
	                	 pw.print("<br>"+" Employee Id : "+r.getString("empid")+"<br>"+"  Employee Name : "+r.getString("empname")+"<br>"+"  Employee Age :  "+r.getString("empage")+"<br>"+"  Employee Password:  "+r.getString("emppass")+"<br>");
	                 }
	            }else {
	            s= c.prepareStatement("SELECT * FROM company.employee  where empname=?");   
	            s.setString(1,user);
	           r = s.executeQuery();
	          pw.println("Hey "+user+" and your details are:" );
	            while (r.next()) {
	            	pw.print("<br>"+" Employee Id : "+r.getString("empid")+"<br>"+"  Employee Name : "+r.getString("empname")+"<br>"+"  Employee Age :  "+r.getString("empage")+"<br>"+"  Employee Password:  "+r.getString("emppass")+"<br>");
	            }
	        }
	            }}
	        catch(Exception e) {e.printStackTrace();}    
	        

	}}


