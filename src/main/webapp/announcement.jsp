<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="models.Announcement " %>
<%@ page import="dao.AnnouncementDAOImpl" %>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
   <head>
   <style>
     #post {
      width: 500px; /* Set the desired width */
      height: 500px; /* Set the desired height */
    }
  </style>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Pluto - Responsive Bootstrap Admin Panel Templates</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- site icon -->
      <link rel="icon" href="images/fevicon.png" type="image/png" />
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css" />
      <!-- site css -->
      <link rel="stylesheet" href="style.css" />
      <!-- responsive css -->
      <link rel="stylesheet" href="css/responsive.css" />
      <!-- color css -->
      <link rel="stylesheet" href="css/colors.css" />
      <!-- select bootstrap -->
      <link rel="stylesheet" href="css/bootstrap-select.css" />
      <!-- scrollbar css -->
      <link rel="stylesheet" href="css/perfect-scrollbar.css" />
      <!-- custom css -->
      <link rel="stylesheet" href="css/custom.css" />
      <!-- calendar file css -->
      <link rel="stylesheet" href="js/semantic.min.css" />
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
    <body class="inner_page contact_page">
      <div class="full_container">
         <div class="inner_container">
         <%@ include file="menu.jsp" %>
            <!-- right content -->
            <div id="content">
                        <div class="col-md-12">
                           <div class="white_shd full margin_bottom_30">
                              <div class="full graph_head">
                                 <div class="heading1 margin_0">
                                    <h2>Daily feed</h2>
                        <%
                        User user = (User) session.getAttribute("user");
						if(user.getRole().matches("admin")){
						%>
						
						<a href="adminAddAnnouncement.jsp" class="button">Add announcement</a>
						<%} %>
                                 </div>
                              </div>
                              <div class="full progress_bar_inner">
                                 <div class="row">
								<div class="col-md-12">
									<div class="msg_list_main">
									<%
									
									  AnnouncementDAOImpl ado = new AnnouncementDAOImpl();
						              ArrayList<Announcement> list = new ArrayList<Announcement>();
						              list = ado.getAllAnnouncements();
						              for(Announcement a : list){
									
									
									%>
										<ul class="msg_list">
											<li><span> <span class="name_user"><%= a.getTitle() %></span>
														<span class="msg_user"><%= a.getDescription() %></span>
														<% Blob blob1 = a.getImage();
																if (blob1 != null) {
																      InputStream inputStream = blob1.getBinaryStream();
																      byte[] imageData = inputStream.readAllBytes();
																      String base64Image = Base64.getEncoder().encodeToString(imageData); %>
														 <br> <br> <span> <img
														id="post" class="image" alt="" src="data:image/jpg;base64,<%=base64Image%>" />
														<% } %>
												</span> <span class="time_ago"><%= a.getPostedAt() %></span>
											</span></li>
										</ul>
									<% } %>	
									</div>
								</div>
							</div>
                              </div>
                           </div>
                        </div>

</div>
</div>
</div>
      <!-- jQuery -->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <!-- wow animation -->
      <script src="js/animate.js"></script>
      <!-- select country -->
      <script src="js/bootstrap-select.js"></script>
      <!-- owl carousel -->
      <script src="js/owl.carousel.js"></script> 
      <!-- chart js -->
      <script src="js/Chart.min.js"></script>
      <script src="js/Chart.bundle.min.js"></script>
      <script src="js/utils.js"></script>
      <script src="js/analyser.js"></script>
      <!-- nice scrollbar -->
      <script src="js/perfect-scrollbar.min.js"></script>
      <script>
         var ps = new PerfectScrollbar('#sidebar');
      </script>
      <!-- custom js -->
      <script src="js/custom.js"></script>
      <!-- calendar file css -->    
      <script src="js/semantic.min.js"></script>
      <script></script>
   </body>
</html>