package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Category;
import beans.Question;
import beans.User;
import bo.QuestionBo;;
@WebServlet("/askform")
public class AskFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	QuestionBo bo;
    public AskFormServlet() {
        super();
       bo = new QuestionBo();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		User user = (User) ses.getAttribute("user");
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int user_id = user.getUser_id();
		int category_id = Integer.parseInt(request.getParameter("category_id")) ;
		Question que = new Question();
		que.setTitle(title);
		que.setContent(content);
		que.setUser_id(user_id);
		que.setCategory_id(category_id);
		try {
			bo.addQuestion(que);
			String destination = "/member_home";
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request,response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
