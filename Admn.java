import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admn
 */
@WebServlet("/Admn")
public class Admn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter p=response.getWriter();
		response.getWriter().append("Served at:").append(request.getContextPath());
		response.setContentType("text/html");
		//String Driver="com.mysql.jdbc.Driver";
		String name=request.getParameter("ev_name");
		String id=request.getParameter("ev_id");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb","root","varuni");
			PreparedStatement ps=con.prepareStatement("select ev_name,ev_id from event_manager where ev_name=? and ev_id=?");
			ps.setString(1,name);
			ps.setString(2,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("http://localhost:8080/Evntmanagement/HOME.html");
				return;
			}
			
				else {
					p.println("INVALID NAME AND ID");
				}
			
		}catch(ClassNotFoundException e)
		{
			System.out.println(""+e);
			
		}catch(SQLException a)
		{
			System.out.println(""+a);
		}
		
		
		
		
	}

}
