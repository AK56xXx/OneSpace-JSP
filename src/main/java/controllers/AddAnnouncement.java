package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.AnnouncementDAOImpl;
import models.Announcement;
import models.User;

/**
 * Servlet implementation class AddAnnouncement
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet({ "/AddAnnouncement", "/addAnnouncement", "/addAnnounce" })
public class AddAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnouncementDAOImpl announcementDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnnouncement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		announcementDAOImpl = new AnnouncementDAOImpl();
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
	     //   int idu = Integer.valueOf(request.getParameter("idu"));
	        String title = request.getParameter("title");
	        String description = request.getParameter("description");       
	        Part filePart = request.getPart("image");
	        if (filePart != null && filePart.getSize() > 0) {
	            InputStream inputStream = filePart.getInputStream();
	            byte[] imageData = inputStream.readAllBytes();

	            // transform the image to a Blob object
	            Blob imageBlob = new javax.sql.rowset.serial.SerialBlob(imageData);

	            Announcement a = new Announcement();
	            a.setTitle(title);
	            a.setDescription(description);
	            a.setImage(imageBlob);
	            announcementDAOImpl.addAnnoucement(a);
	        } else {
	        	 Announcement a = new Announcement();
		            a.setTitle(title);
		            a.setDescription(description);
		            announcementDAOImpl.addAnnoucement(a);
	        }
	
	        response.sendRedirect("announcement.jsp");
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception appropriately
	    }
	}

}
