package controller;

import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBo ub;
    public DeleteUserServlet() {
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
			
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			try {
				ub.deleteUser(user_id);
				destination = "/manageUser";
				RequestDispatcher rd = request.getRequestDispatcher(destination);
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
