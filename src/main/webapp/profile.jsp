<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="dao.UserDAOImpl" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
   <head>
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
   <body class="inner_page profile_page">
      <div class="full_container">
         <div class="inner_container">
         
         <%@ include file="menu.jsp" %>
            <!-- right content -->
            <div id="content">
            
            <%
            
            try {
    			User uc = (User) session.getAttribute("user");
            
            	
            	
            	
            	UserDAOImpl ud = new UserDAOImpl();
            	
            
            %>
              
               <!-- dashboard inner -->
               <div class="midde_cont">
                  <div class="container-fluid">
                     <div class="row column_title">
                        <div class="col-md-12">
                           <div class="page_title">
                              <h2>Profile</h2>
                           </div>
                        </div>
                     </div>
                     <!-- row -->
                <% if (request.getParameter("idu") != null && !request.getParameter("idu").isEmpty()) { %>
                     <div class="row column1">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                           <div class="white_shd full margin_bottom_30">
                              <div class="full graph_head">
                                 <div class="heading1 margin_0">
                                    <h2>User profile</h2>
                               
                                    <a href="updateProfile.jsp" class="button">Edit</a>
                                    
                                 </div>
                              </div>
                              <div class="full price_table padding_infor_info">
                                 <div class="row">
                                    <!-- user profile section --> 
                                    <!-- profile image -->
                                    <div class="col-lg-12">
                                       <div class="full dis_flex center_text">
                                       <% Blob blob = uc.getPicture();
																if (blob != null) {
																      InputStream inputStream = blob.getBinaryStream();
																      byte[] imageData = inputStream.readAllBytes();
																      String base64Image = Base64.getEncoder().encodeToString(imageData); %>
                                          <div class="profile_img"><img width="180" class="rounded-circle" src="data:image/jpg;base64,<%=base64Image%>" alt="#" /></div>
                                          <% } %>
                                          <div class="profile_contant">
                                             <div class="contact_inner">
                                                <h3><%= uc.getFname()+" "+uc.getLname() %></h3>
                                                <p><strong>Position: </strong><%= uc.getPosition() %></p>
                                                <ul class="list-unstyled">
                                                   <li><i class="fa fa-envelope-o"></i> : <%= uc.getEmail() %></li>
                                                   <li><i class="fa fa-phone"></i> : <%= uc.getTel() %></li>
                                                </ul>
                                             </div>
                                             
                                          </div>
                                       </div>
                                       
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="col-md-2"></div>
                        </div>
                        <!-- end row -->
                        <% } %>
                        
                        
                        
                         <!-- row -->
                     <%
                     if(request.getParameter("idc") != null && !request.getParameter("idc").isEmpty()){
                    	 int idc = Integer.valueOf((String)request.getParameter("idc"));
                    	 User contact = new User();
                     	
                     	 contact = ud.getUserById(idc);
                     %>
                     <div class="row column1">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                           <div class="white_shd full margin_bottom_30">
                              <div class="full graph_head">
                                 <div class="heading1 margin_0">
                                    <h2>User profile</h2>
                              
                                    
                                 </div>
                              </div>
                              <div class="full price_table padding_infor_info">
                                 <div class="row">
                                    <!-- user profile section --> 
                                    <!-- profile image -->
                                    <div class="col-lg-12">
                                       <div class="full dis_flex center_text">
                                       <% Blob blob1 = contact.getPicture();
																if (blob1 != null) {
																      InputStream inputStream = blob1.getBinaryStream();
																      byte[] imageData = inputStream.readAllBytes();
																      String base64Image = Base64.getEncoder().encodeToString(imageData); %>
                                          <div class="profile_img"><img width="180" class="rounded-circle" src="data:image/jpg;base64,<%=base64Image%>" alt="#" /></div>
                                          <% } %>
                                          <div class="profile_contant">
                                             <div class="contact_inner">
                                                <h3><%= contact.getFname()+" "+contact.getLname() %></h3>
                                                <p><strong>Position: </strong><%= contact.getPosition() %></p>
                                                <ul class="list-unstyled">
                                                   <li><i class="fa fa-envelope-o"></i> : <%= contact.getEmail() %></li>
                                                   <li><i class="fa fa-phone"></i> : <%= contact.getTel() %></li>
                                                </ul>
                                             </div>
                                             
                                          </div>
                                       </div>
                                       
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="col-md-2"></div>
                        </div>
                        <!-- end row -->
                        <% } %>
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                     </div>
                     <!-- footer -->
                     <div class="container-fluid">
                        <div class="footer">
                        
                        </div>
                     </div>
                  </div>
                  <!-- end dashboard inner -->
               </div>
               <%
                }catch(Exception e) {
                	e.printStackTrace();
                }
               %>
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
   </body>
</html>