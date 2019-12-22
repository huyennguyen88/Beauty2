package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import bo.CheckLoginBo;
import dao.CheckLoginDao;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CheckLoginBo checkloginBo ;
    public LoginServlet() {
        super();
        checkloginBo = new CheckLoginBo();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User u= checkloginBo.checkUserLogin(email, password) ;
		String destination =null;

		
		
		if( u!=null) {
			HttpSession ses=request.getSession();
			ses.setAttribute("user",u);
			
			if(u.getRole()==1)
			{
				destination = "/consultant_home";
				RequestDispatcher rd = request.getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if(u.getRole()==3) {
				destination = "/admin_home";
				RequestDispatcher rd = request.getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else {
				destination = "/home";
				RequestDispatcher rd = request.getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}
		else {

			destination = "/home";
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		
	
	}

}
