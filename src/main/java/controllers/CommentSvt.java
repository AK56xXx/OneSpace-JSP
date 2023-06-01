package controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAOImpl;
import models.Comment;
import models.Post;

/**
 * Servlet implementation class CommentSvt
 */
@WebServlet({ "/CommentSvt", "/Comment", "/comment", "/reply", "/respond" })
public class CommentSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAOImpl commentDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentSvt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		commentDAOImpl = new CommentDAOImpl();
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
			int idp = Integer.valueOf((String)request.getParameter("idp"));
			String reply = (String) request.getParameter("reply");
			
			Comment c = new Comment();
			c.setIdUser(idu);
			c.setIdPost(idp);
			c.setReply(reply);
			
			commentDAOImpl.addComment(c);
			response.sendRedirect("comment.jsp?idp="+idp);
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("error servlet add post !");
			}
	}

}
