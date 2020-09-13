import java.io.*;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public login() {
        //super();
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
		String eid=request.getParameter("ev_id");
		int id=Integer.valueOf(eid);
		if(Validate.checkUser(name,id))
		{RequestDispatcher rs=request.getRequestDispatcher("http://localhost:8080/Evntmanagement/HOME.html");
		rs.forward(request, response);
		
			
		}
		else
		{
			out.println("incorrect login");
			RequestDispatcher rs=request.getRequestDispatcher("LOGIN.html");
			rs.include(request, response);
		}
	}
}
			
		
			
		