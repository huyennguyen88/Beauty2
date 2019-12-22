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

import beans.Category;
import beans.User;
import dao.CategoryDao;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDao cd;
    public HomeServlet() {
        super();
        cd = new CategoryDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		 HttpSession ses = request.getSession();
		 User u =(User) ses.getAttribute("user");
		 if(u!=null) {
			 request.setAttribute("user", u);
		 }
		 
		 List<Category> categoryList = cd.getAll();
         request.setAttribute("categoryList", categoryList);
   
		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/homeView.jsp");
	        
	     dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
