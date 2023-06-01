package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDAOImpl;
import models.Message;

/**
 * Servlet implementation class MessageSvt
 */
@WebServlet({ "/MessageSvt", "/Message", "/message" })
public class MessageSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageDAOImpl messageDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageSvt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		messageDAOImpl = new MessageDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd;
			
		String message = (String) request.getParameter("msg");
		
		String sidu =  (String)request.getParameter("idu");
		String sidc =  (String)request.getParameter("idc");
		int idu = Integer.valueOf(sidu);
		int idc = Integer.valueOf(sidc);
		
		Message msg = new Message();
		msg.setSender(idu);
		msg.setReceiver(idc);
		msg.setMessage(message);
		
		messageDAOImpl.addMessage(msg);
		
		System.out.println("message sended");
		
		response.sendRedirect("message.jsp?idc="+idc);
		}catch(Exception e)
		{
			System.out.println("Error send message servlet : " + e.getMessage());
			e.printStackTrace();
						
		}
		
		
	}

}
