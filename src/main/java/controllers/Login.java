package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAOImpl;
import extra.values.Strings;
import models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login", "/connect" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		userDAOImpl = new UserDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("connexion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");

		RequestDispatcher rd;
		// verify username & role
		int x = userDAOImpl.verifyLogin(username, password);
		int role = userDAOImpl.verifyRole(username, password);
		int exist = userDAOImpl.exist(username);

		if (x == 1) {

			User user = userDAOImpl.getUserByUsername(username);

			HttpSession session = request.getSession();

			session.setAttribute("user", user);
			
			rd = request.getRequestDispatcher("announcement.jsp");
				
		} else {
			request.setAttribute("ERROR", Strings.ERROR_DB_PROBLEM);
			rd = request.getRequestDispatcher("connexion.jsp");
		}
		
		rd.forward(request, response);
		
	}
	
	

}
