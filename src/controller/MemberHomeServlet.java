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

import beans.User;
import bo.QuestionWAnswerBo;
import beans.Question;
import beans.QuestionWAnswer;
import dao.QuestionWAnswerDao;


@WebServlet("/member_home")
public class MemberHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    QuestionWAnswerBo qd;
    public MemberHomeServlet() {
        super();
        qd = new QuestionWAnswerBo();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession();
		User u = (User) ses.getAttribute("user");
		String destination=null;
		if(u==null) {
			response.sendRedirect(this.getServletContext().getContextPath()+"/home");
			return;
		}
		else if(u.getRole()==0) {
			List<Question> penlist = qd.getMyPendingQuestion(u.getUser_id());
			List<QuestionWAnswer> donelist = qd.getMyDoneQuestion(u.getUser_id());
			destination = "/WEB-INF/view/memberHome.jsp";
			request.setAttribute("user", u);
			request.setAttribute("penList", penlist);
			request.setAttribute("doneList", donelist);
			
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
