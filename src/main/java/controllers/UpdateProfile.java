package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.UserDAOImpl;
import models.User;

/**
 * Servlet implementation class UpdateProfile
 */

@MultipartConfig(maxFileSize = 16177215)
@WebServlet({ "/UpdateProfile", "/updateProfile", "/editProfile" })
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   try {
		        int idu = Integer.valueOf(request.getParameter("idu"));
		        String email = request.getParameter("email");
		        String tel = request.getParameter("tel");
		        
		        Part filePart = request.getPart("picture");
		        if (filePart != null && filePart.getSize() > 0) {
		            InputStream inputStream = filePart.getInputStream();
		            byte[] imageData = inputStream.readAllBytes();

		            // transform the image to a Blob object
		            Blob imageBlob = new javax.sql.rowset.serial.SerialBlob(imageData);

		            User u = userDAOImpl.getUserById(idu);
		            u.setEmail(email);
		            u.setTel(tel);
		            u.setPicture(imageBlob);
		            userDAOImpl.updateUser(u);
		        } else {
		            User u = userDAOImpl.getUserById(idu);
		            u.setEmail(email);
		            u.setTel(tel);
		            userDAOImpl.updateUser(u);
		        }
		
		        response.sendRedirect("profile.jsp?idu=" + idu);
		    } catch (Exception e) {
		        e.printStackTrace();
		        // Handle the exception appropriately
		    }
	
	
	}

}
