import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Customerinsertservlet
 */
@WebServlet("/Customerinsertservlet")
public class Customerinsertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public Customerinsertservlet() {
        //super();
        // TODO Auto-generated constructor stub
   // }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String id=request.getParameter("c_id");
		String name=request.getParameter("c_name");
		String phone=request.getParameter("c_pho");
		int phoneIntValue=Integer.parseInt(phone);
		String ename=request.getParameter("e_name");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb","root","varuni");
			PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?)");
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setInt(3,phoneIntValue);
			ps.setString(4,ename);
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



	


