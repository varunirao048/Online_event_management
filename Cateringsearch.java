
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Cateringsearch
 */
@WebServlet("/Cateringsearch")
public class Cateringsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public Cateringsearch() {
      //  super();
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
		String no=request.getParameter("no_of_items");
		int id=Integer.valueOf(no);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb","root","varuni");
			PreparedStatement ps=con.prepareStatement("select * from catering where no_of_items=?");
			ps.setInt(1,id);
			out.print("<table width=50% border=1>");
			out.print("<caption>result:</caption>");
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next())
			{
				out.print("<tr>");
				 out.print("<tr>"+rsmd.getColumnName(1)+"</td>");
				 out.print("<td>"+rs.getInt(1)+"</td></tr>");
				 out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
				 out.print("<td>"+rs.getString(2)+"</td></tr>");
				 out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
				 out.print("<td>"+rs.getInt(3)+"</td></tr>");
				 out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
				 out.print("<td>"+rs.getInt(4)+"</td></tr>");
				 
			}
			out.print("</table>");
		}catch(Exception e2)
		{
			e2.printStackTrace();
			
		}
		finally {out.close();
		}
	}public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);}
}


	

	