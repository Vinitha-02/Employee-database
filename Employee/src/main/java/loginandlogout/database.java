package loginandlogout;

import java.sql.*;
public class database {
		
	public static   boolean validate(String empname, String emppass) 
	{
		boolean status = false;  
	
		try{  
	Class.forName("com.mysql.cj.jdbc.Driver");
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","12345");
		System.out.println("Driver connected");
		PreparedStatement ps= con.prepareStatement("SELECT * FROM company.employee  where empname=? and emppass=?");
			
				ps.setString(1,empname);  
			ps.setString(2,emppass);  
				ResultSet rs=ps.executeQuery();  

if(rs.next()){
	status= true;
}
	   ps.close();
	   con.close();
	   }catch(Exception e)
		{e.printStackTrace();}
		return status;
}
}