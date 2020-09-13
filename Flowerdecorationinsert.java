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
 * Servlet implementation class Flowerdecorationinsert
 */
@WebServlet("/Flowerdecorationinsert")
public class Flowerdecorationinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public Flowerdecorationinsert() {
     //   super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("f_type");
		String no=request.getParameter("no_of_flowers");
		int noIntValue=Integer.parseInt(no);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb","root","varuni");
			PreparedStatement ps=con.prepareStatement("insert into flower_decoration values(?,?)");
			ps.setString(1,fname);
			ps.setInt(2,noIntValue);
		
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



	

	