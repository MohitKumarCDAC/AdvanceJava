package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class VoterRegistration
 */
@WebServlet("/voter_register")
public class VoterRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoterRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	//servlet init(lifecycle) method run only once 
	public void init(ServletConfig config) throws ServletException {
		try {
			//create instance of UserDaoImpl
			userdao=new UserDaoImpl();
		} catch (Exception e) {
			System.out.println(e);

			throw new ServletException("we are in init"+getClass(),e);
		}
	}
	//destroy run only once
	//and call USerDaoImpl cleanup method
	public void destroy()
	{
		try {
			userdao.cleanUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in destroy!");	
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//and service method each service for one
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set response content type
		//setContentType me
		response.setContentType("text/html");
		//2 get pw to send text
		try (PrintWriter pw=response.getWriter()){
			//read request parameter
			String firstname=request.getParameter("fn");
			String lastname=request.getParameter("ln");
			String email=request.getParameter("em");
			String pass=request.getParameter("pass");
			String dob=request.getParameter("dob");
			//LocalDateTime.parse(dob);
		     long date= userdao.validateAge(dob);
		     if(date==-1)
		     {
		    	 pw.print("Yor are under age!");
		     }
		     else
		     {
		
				User user=new User(firstname, lastname, email, pass, Date.valueOf(dob));
				userdao.voterRegistration(user);
				response.sendRedirect("login.html");
				
		     }
		     
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
	}


