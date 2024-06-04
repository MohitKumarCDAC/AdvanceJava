package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

/**
 * Servlet implementation class CandidateListPage
 */
@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 . set resp cont type
		response.setContentType("text/html");
		// 2. PW
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5> In candidate list page <h5>");
			// 3. read cookie from the request header
			//here we use array[] because data is in group
//			Cookie[] cookies = request.getCookies();
			//we use httpsession()
			HttpSession session=request.getSession();
			System.out.println("session new: "+session.isNew());//f provided cookies are accepted
			System.out.println("session Id: "+session.getId());
			//get userdetails from HttpSession.
			User userinfo=(User)session.getAttribute("user_info");
			if (userinfo != null) {
				//here we use loop because data is in array its an cookie part
//				for (User c : session)
//					if (c.getName().equals("user_info")) {
//						pw.print("<h5> User details " + c.getValue() + "</h5>");
//						break;
//					}
				//here we print this data into client pc data fetch from cookies
//				pw.write("<h5>user Details"+userinfo.getUserId()+" "+userinfo.getFirstName()+" "+userinfo.getLastName()+" "+
//				userinfo.getEmail()+" "+userinfo.getPassword()+" "+userinfo.getDob()+" "+userinfo.getRole()+" "+userinfo.getRole());
				
				//get candidate dao from session
				CandidateDaoImpl dao=(CandidateDaoImpl) session.getAttribute("candidate_dao");
				pw.print("<h5>hello ,"+userinfo.getFirstName()+" "+userinfo.getLastName() +"</h5>");
				//get candidate list from candidate dao
				List<Candidate> candidates=dao.getCandidateDetails();
				//dynamic form generation
				pw.write("<form action='logout' method=post>");
				//iterate over candidate list
				for(Candidate c:candidates)
					pw.print("<h5> <input type='radio' "
							+ "name='candidate_id' "
							+ "value='" + c.getCandidateId() + "'/>"
							+ c.getCandidateName() + "</h5>");
				//submit button
				pw.print("<h6> <input type='submit' value='Cast A Vote'/></h6>");
				pw.print("</form>");
				
				
				
			} else
				pw.print("<h5> Can't remember the clnt , No Cookies!!!!!!</h5>");

		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass(), e);
		}
	}

}
