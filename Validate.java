import java.sql.*;
public class Validate {
 public static boolean checkUser(String name,int eid)
 {
	 boolean st=false;
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb","root","varuni");
		 PreparedStatement ps=con.prepareStatement("select *from event_manager where ev_name=? and ev_id=?");
		 ps.setString(1,name);
		 ps.setInt(2,eid);
		 ResultSet rs=ps.executeQuery();
		 st=rs.next();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }return st;
	 
 }
}
