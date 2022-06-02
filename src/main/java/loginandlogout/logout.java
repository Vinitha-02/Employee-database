package loginandlogout;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class logout extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)  
            throws ServletException, IOException {  
res.setContentType("text/html");  
PrintWriter out=res.getWriter();  

req.getRequestDispatcher("link.html").include(req, res);  

HttpSession session=req.getSession();  
session.invalidate();  

out.print("You are successfully logged out!");  
RequestDispatcher rd = req.getRequestDispatcher("Indexhtml.html");
rd.include(req, res);

out.close();  
}  

}
