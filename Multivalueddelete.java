

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Multivalueddelete
 */
@WebServlet("/Multivalueddelete")
public class Multivalueddelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public Multivalueddelete() {
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
		String name=request.getParameter("e_name");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String user="root";
			String pass="varuni";
			String query="delete from multivalued where e_name=?";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagementdb",user,pass);
			PreparedStatement ps=con.prepareStatement("delete from multivalued where e_name=?");
			ps.setString(1,name);
			int i=ps.executeUpdate();
			if(i>0) {
				out.println("deleted successfully");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			
			}
		}
	}
	


