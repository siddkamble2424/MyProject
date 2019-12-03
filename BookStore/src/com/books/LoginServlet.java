package com.books;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		User u = new User();
		u.setName(uname);
		u.setPassword(pwd);
		boolean ans=false;
		
		
		
		try {
			ans = UserDao.validate(u);
		} 
		catch (Exception u1) {
			
			u1.printStackTrace();
		
		}
		
		
		if(ans == true)
		{
			pw.write("Login Successfull "+uname);
			request.getRequestDispatcher("Home.html")
			.include(request, response);
		}
		else
		{
			pw.write("Please enter correct username and password");
			request.getRequestDispatcher("index.html")
			.include(request, response);
		}
		
		
		
	}
		
			
		
		
	
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
