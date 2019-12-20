package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import beans.Category;
@WebServlet("/askform")
public class AskFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDao cd;
	
    public AskFormServlet() {
        super();
        cd = new CategoryDao();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Category> categoryList = cd.getAll();
         request.setAttribute("categoryList", categoryList);
         
		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/askForm.jsp");
	        
	     dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
