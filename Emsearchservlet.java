import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Emsearchservlet
 */
@WebServlet("/Emsearchservlet")
public class Emsearchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  //  public Emsearchservlet() {
    //    super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		/*out.println("<html>");
		out.println("<head><title>existing records</title></head>");
		out.println("<body>");
		out.println("<h1>EXISTING RECORDS</h1>");
		out.println("</body></html>");*/
		
		String name=request.getParameter("ev_name");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb","root","varuni");
			 PreparedStatement ps=con.prepareStatement("select * from event_manager where ev_name=?");
			 ps.setString(1,name);
			 out.print("<table width=25% border=1>");
			 out.print("<center><h1>Result:</h1></center>");
			 
			 ResultSet rs=ps.executeQuery();
			 
			 ResultSetMetaData rsmd=rs.getMetaData(); 
			 while(rs.next()) {
				 out.print("<tr>");
				 out.print("<tr>"+rsmd.getColumnName(1)+"</td>");
				 out.print("<td>"+rs.getString(1)+"</td></tr>");
				 out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
				 out.print("<td>"+rs.getString(2)+"</td></tr>");
				 out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
				 out.print("<td>"+rs.getString(3)+"</td></tr>");
			 }
			 out.print("</table>");
				/*out.print(rs.getObject(1).toString());
				 out.print("\t\t\t");
				 out.print(rs.getObject(2).toString());
				 out.print("\t\t\t");
				 out.print(rs.getObject(3).toString());
				 out.print("<br>");*/
			 //}
		} catch(Exception e2)
			 {e2.printStackTrace();
			 }
		finally{out.close();
			 }}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                       doGet(request,response);}
}
				