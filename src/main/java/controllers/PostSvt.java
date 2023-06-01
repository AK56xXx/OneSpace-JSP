package controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAOImpl;
import models.Post;

/**
 * Servlet implementation class PostSvt
 */
@WebServlet({ "/PostSvt", "/Post", "/post" })
public class PostSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostDAOImpl postDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostSvt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		postDAOImpl = new PostDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		int idu = Integer.valueOf((String)request.getParameter("idu"));
		
		String poster = (String) request.getParameter("poster");
		
		Post p = new Post();
		p.setText(poster);
		p.setIdUser(idu);
		postDAOImpl.addPost(p);
		response.sendRedirect("post.jsp");
		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error servlet add post !");
		}
		
		
		
	}

}
