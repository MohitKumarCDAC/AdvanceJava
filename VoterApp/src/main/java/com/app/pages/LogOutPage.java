package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class LogOutPage
 */
@WebServlet("/logout")
public class LogOutPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			//get HttpSession from web Container
			HttpSession session=request.getSession();
			System.out.println("session new: "+session.isNew());
			System.out.println("Session ID: "+session.getId());
			User user=(User)session.getAttribute("user_info");
			if(user!=null)
			{
				//hello voter
				pw.write("<h5> Hello,"+user.getFirstName()+" "+user.getLastName()+"</h5>");
				//add logout link only for admin user
				if(user.getRole().equals("admin"))
				{
				pw.write("<h5><a href='login.html'>visite again</a></h5>");
				}
				else
				{
					pw.print("<h5>you have allready voted</h5>");
					pw.print("<h5>You have logged out</h5>");
				}
			}
			else
			{
				pw.print("<h5> Can't remember the clnt , No Cookies!!!!!!</h5>");
			}
			//invalidate session
			session.invalidate();
			//Server side HttpSession is marked for GC , 
			//i.e all session scoped attributes
			//are unbound from the session
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		try(PrintWriter pw=res.getWriter()){
			//1get http session from wc
			HttpSession session=req.getSession();
			//2get user details.daos-- user n candidate dao
			User user=(User)session.getAttribute("user_info");
			if(user!=null) {
				//3 get dao
				//get candidate dao from session
				CandidateDaoImpl candidateDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
				UserDaoImpl userDao = (UserDaoImpl) session.getAttribute("user_dao");
				// Hello voter name
				pw.print("<h5> Hello , " + user.getFirstName() + " " + user.getLastName() + "</h5>");
				// 4. get selected candidate id
				int candidateId = Integer.parseInt(req.getParameter("candidate_id"));
				// 5. invoke dao's method to increment the votes
				pw.print("<h5> " + candidateDao.incrementCandidatevote(candidateId) + "</h5>");
				// 6. change voting status
				pw.print("<h5> " + userDao.updateVotingStatus(user.getUserId()) + "</h5>");
				pw.print("<h5> You have logged out....</h5>");
			} else
				pw.print("<h5> Can't remember the clnt , No Cookies!!!!!!</h5>");

			// invalidate session
			session.invalidate();// Server side HttpSession is marked for GC , i.e all session scoped attributes
									// are un bound from the session
			}catch (Exception e) {
				throw new ServletException("err in do-post of " + getClass(), e);
			}
		}
	}


