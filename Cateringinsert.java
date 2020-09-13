import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Cateringinsert
 */
@WebServlet("/Cateringinsert")
public class Cateringinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public Cateringinsert() {
     //   super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String no=request.getParameter("no_of_items");
		int noIntValue=Integer.parseInt(no);
		String name=request.getParameter("e_name");
		String quo=request.getParameter("quotation");
		int quoIntValue=Integer.parseInt(quo);
		String pho=request.getParameter("phone");
		int phoIntValue=Integer.parseInt(pho);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb","root","varuni");
			PreparedStatement ps=con.prepareStatement("insert into catering values(?,?,?,?)");
			ps.setInt(1,noIntValue);
			ps.setString(2,name);
			ps.setInt(3,quoIntValue);
			ps.setInt(4,phoIntValue);
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



	


