import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Eminsertservlet
 */
@WebServlet("/Eminsertservlet")
public class Eminsertservlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
   // public Eminsertservlet() {
        // TODO Auto-generated constructor stub
   // }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("ev_name");
		String phone=request.getParameter("ev_phone");
		String id=request.getParameter("ev_id");
		int phoneIntValue=Integer.parseInt(phone);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb","root","varuni");
			PreparedStatement ps=con.prepareStatement("insert into event_manager values(?,?,?)");
			ps.setString(1, name);
			ps.setInt(2,phoneIntValue);
			ps.setString(3, id);
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("successfully inserted");
			}
		}
		catch(Exception se)
		{
			se.printStackTrace();
			}
			
			
		}
	}


