package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Question;
import beans.User;
import bo.QuestionBo;
@WebServlet("/consultant_home")
public class ConsultantHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    QuestionBo qb;
    public ConsultantHomeServlet() {
        super();
        qb = new QuestionBo();
        

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession();
		User u = (User) ses.getAttribute("user");
		String destination=null;
		if(u==null) {
			response.sendRedirect(this.getServletContext().getContextPath()+"/home");
			return;
		}
		else if(u.getRole()==1) {
			List<Question> penlist = qb.getPendingQuestions();
			destination = "/WEB-INF/view/consultantHome.jsp";
			request.setAttribute("user", u);
			request.setAttribute("allPen",penlist);
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
