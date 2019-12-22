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
import bo.UserBo;
@WebServlet("/manageUser")
public class ManageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserBo ub;
    public ManageUserServlet() {
        super();
        ub = new UserBo();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession();
		User u = (User) ses.getAttribute("user");
		String destination=null;
		if(u==null) {
			response.sendRedirect(this.getServletContext().getContextPath()+"/home");
			return;
		}
		else if(u.getRole()==3) {
			List<User> userList = ub.getAll();
			request.setAttribute("userList",userList);
			destination = "/WEB-INF/view/manageUser.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
