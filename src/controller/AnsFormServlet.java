package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Answer;
import beans.Question;
import beans.User;
import bo.AnswerBo;
import bo.QuestionBo;
@WebServlet("/ansform")
public class AnsFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AnswerBo ansbo;
	QuestionBo quesbo;
    public AnsFormServlet() {
        super();
        ansbo = new  AnswerBo();
        quesbo = new QuestionBo();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		User user = (User) ses.getAttribute("user");
		if(user.getRole()==1) {
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html; charset=UTF-8");
			String content = request.getParameter("content");
			int user_id = user.getUser_id();
			int question_id = Integer.parseInt(request.getParameter("question_id")) ;
			Answer ans = new Answer();
			ans.setContent(content);
			ans.setUser_id(user_id);
			ans.setQuestion_id(question_id);
			Question que = quesbo.getOneQuestion(question_id);
			try {
				ansbo.addAnswer(ans);
				quesbo.updateQueStatus(que);
				String destination = "/consultant_home";
				RequestDispatcher rd = request.getRequestDispatcher(destination);
				rd.forward(request,response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			String destination = "/home";
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request,response);
		}
	    
		
	}

}
