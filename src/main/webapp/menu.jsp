<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="models.User" %>
    <%@ page import="java.sql.*" %>
	<%@ page import="javax.sql.*" %>
	<%@ page import="java.io.*" %>
	<%@ page import="java.util.*" %>
 
      <nav id="sidebar">
      <%
      try {
      User user = (User) session.getAttribute("user");
   // convert Blob objct to an image
      Blob blob = user.getPicture();
      
      %>
               <div class="sidebar_blog_1">
                  <div class="sidebar-header">
                     <div class="logo_section">
                        <a href="index.html"><img class="logo_icon img-responsive" src="images/logo/logo_icon.png" alt="#" /></a>
                     </div>
                  </div>
                  <div class="sidebar_user_info">
                     <div class="icon_setting"></div>
                     <div class="user_profle_side">
                     <% if (blob != null) {
                         InputStream inputStream = blob.getBinaryStream();
                         byte[] imageData = inputStream.readAllBytes();
                         String base64Image = Base64.getEncoder().encodeToString(imageData); %>
                        <div class="user_img"><img class="img-responsive" src="data:image/jpg;base64,<%=base64Image%>" alt="#" /></div>
                        <% } %>
                        <div class="user_info">
                           <h6><%= user.getFname()+" "+user.getLname() %></h6>
                           <p><span class="online_animation"></span> Online</p>
                        </div>
                     </div>
                  </div>
               </div>
                <div class="sidebar_blog_2">
                  <h4>General</h4>
                  <ul class="list-unstyled components">
                  	<li><a href="announcement.jsp"><i class="fa fa-bell yellow_color"></i> <span>Announcements</span></a></li>
                   
                     <li><a href="post.jsp"><i class="fa fa-home orange_color"></i> <span>Posts</span></a></li>
              
                     
               
    
                     <li>
                        <a href="contact.jsp">
                        <i class="fa fa-users"></i> <span>Contact</span></a>
                     </li>
					 <li><a href="storage.jsp"><i class="fa fa-table"></i> <span>File storage</span></a></li>
					 <%
						
						if(user.getRole().matches("admin")){
						%>
                     <li class="active">
                        <a href="#additional_page" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-clone yellow_color"></i> <span>Settings</span></a>
                        <ul class="collapse list-unstyled" id="additional_page">
                           <li>
                              <a href="adminUserIndex.jsp"> <span>Users</span></a>
                           </li>
                           <li>
                              <a href="adminAnnouncementIndex.jsp"> <span>Announcements</span></a>
                           </li>
                           <li>
                              <a href="adminStorageIndex.jsp"> <span>Files Storage</span></a>
                           </li>
                        </ul>
                     </li>
                     <%
						}    
                     %>
                     
            
                  </ul>
               </div>
            </nav>
            <!-- end sidebar -->
            <!-- right content -->
               <!-- topbar -->
               <div class="topbar">
                  <nav class="navbar navbar-expand-lg navbar-light">
                     <div class="full">
                        <button type="button" id="sidebarCollapse" class="sidebar_toggle"><i class="fa fa-bars"></i></button>
                        <div class="logo_section">
                           <a href="index.html"><img class="img-responsive" src="images/logo/logo.png" alt="#" /></a>
                        </div>
                        <div class="right_topbar">
                           <div class="icon_info">
                              <ul>
                                 <li><a href="#"><i class="fa fa-bell-o"></i><span class="badge">2</span></a></li>
                                 <li><a href="#"><i class="fa fa-question-circle"></i></a></li>
                                 <li><a href="#"><i class="fa fa-envelope-o"></i><span class="badge">3</span></a></li>
                              </ul>
                              <ul class="user_profile_dd">
                                 <li>
                                 <%if (blob != null) {
                                     InputStream inputStream = blob.getBinaryStream();
                                     byte[] imageData = inputStream.readAllBytes();
                                     String base64Image = Base64.getEncoder().encodeToString(imageData); %>
                                    <a class="dropdown-toggle" data-toggle="dropdown"><img class="img-responsive rounded-circle" src="data:image/jpg;base64,<%=base64Image%>" alt="#" /><span class="name_user"><%= user.getFname()+" "+user.getLname() %></span></a>
                                    <% } %>
                                    <div class="dropdown-menu">
                                       <a class="dropdown-item" href="profile.jsp?idu=<%=user.getId()%>">My Profile</a>
                                       <a class="dropdown-item" href="help.html">Help</a>
                                       <a class="dropdown-item" href="Logout"><span>Log Out</span> <i class="fa fa-sign-out"></i></a>
                                    </div>
                                 </li>
                              </ul>
                           </div>
                        </div>
                     </div>
                  </nav>
               </div>
               <%
               
      }catch(Exception e)
      {
    	  e.printStackTrace();
      }
                   
               %>