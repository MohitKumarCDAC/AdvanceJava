package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.entities.Candidate;

/**
 * Servlet implementation class AdminPageServlet
 */
@WebServlet("/admin_page")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidateDaoImpl candidatedaoilpl;

	//create object of candidate Daw
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			pw.print("<h1>We are in Admin Page:</h1>");
			HttpSession session=request.getSession();
			//syso means data display on console
			//PrintWriter means data display on browser
			System.out.println("session new: "+session.isNew());
			System.out.println("Session ID: "+session.getId());
			CandidateDaoImpl dao=(CandidateDaoImpl) session.getAttribute("candidate_dao");
			
			//get candidate list from candidate dao
			List<Candidate> candidates=dao.getMaxVotes();
			List<Candidate> candi=dao.getmaxVotesOfParty();
			
			pw.print("<h3>Top Two Voters Which have Maximum Count Of Votes:</h3>");
			pw.print("<table border='1'>");
			pw.print("<tr><th>Candidate ID</th><th>Candidate Name</th><th>Party</th><th>Votes</th></tr>");

			for(Candidate c:candidates) {
			    pw.print("<tr>");
			    pw.print("<td>" + c.getCandidateId()+ "</td>");
			    pw.print("<td>" + c.getCandidateName() + "</td>");
			    pw.print("<td>" + c.getParty() + "</td>");
			    pw.print("<td>" + c.getVotes() + "</td>");
			    pw.print("</tr>");
			}

			pw.print("</table>");
			
			pw.print("<h1>Display Votes Analysis Party Wise<h1>");
			pw.print("<table border='1'>");
			pw.print("<tr><th>Candidate Name</th><th>Party</th></tr>");

			for(Candidate cd:candi) {
			    pw.print("<tr>");
			    pw.print("<td>" + cd.getParty() + "</td>");
			    pw.print("<td>" + cd.getVotes() + "</td>");
			    pw.print("</tr>");
			}
			pw.print("</table>");
			pw.print("<h4>Logout From this page:!<h4>");
			pw.print("<h3><button type='submit'><a href='login.html'>LogOut</a></button></h3>");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
