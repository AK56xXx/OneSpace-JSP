<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="models.Post " %>
<%@ page import="models.Comment " %>
<%@ page import="dao.UserDAOImpl" %>
<%@ page import="dao.PostDAOImpl" %>
<%@ page import="dao.CommentDAOImpl" %>
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
<link rel="stylesheet" href="css/postStyle.css" />
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
			<%@ include file="menu.jsp"%>
			<!-- right content -->
			<div id="content">
			
			<%
			try {
			User uc = (User) session.getAttribute("user");
			
			int idp = Integer.parseInt(request.getParameter("idp"));
            PostDAOImpl pdo = new PostDAOImpl();
            
            Post post = new Post();
            post = pdo.getPostById(idp);
            
            UserDAOImpl ud = new UserDAOImpl();
            User u = new User();
            u = ud.getUserById(post.getIdUser());
			
			
			
			%>
				<div class="col-md-12">
					<div class="white_shd full margin_bottom_30">
						<div class="full graph_head">
							<div class="heading1 margin_0">
								<h2>Daily feed</h2>
							</div>
						</div>
						<div class="full progress_bar_inner">
							<div class="row">
								<div class="col-md-12">
						
									<section class="content-item" id="comments">
										<div class="container">
											<div class="row">
												<div class="col-sm-12">
												<div class="media">
												
														<div class="col-sm-3 col-lg-2 hidden-xs">
														<% Blob blob = u.getPicture();
																if (blob != null) {
																      InputStream inputStream = blob.getBinaryStream();
																      byte[] imageData = inputStream.readAllBytes();
																      String base64Image = Base64.getEncoder().encodeToString(imageData); %>
																	<img class="img-responsive"
																		src="data:image/jpg;base64,<%=base64Image%>"
																		alt="">
																		<% } %>
																</div>
														<div class="media-body">
															<h4 class="media-heading"><%= u.getFname()+" "+u.getLname() %></h4>
															<strong><p><%= post.getText() %></p></strong>
															<ul
																class="list-unstyled list-inline media-detail pull-left">
																<li><i class="fa fa-calendar"></i><%= post.getPostedAt() %></li>
																<li><i class="fa fa-thumbs-up"></i>13</li>
															</ul>
															<ul
																class="list-unstyled list-inline media-detail pull-right">
															
															</ul>
														</div>
													</div>
													
													<br>
													<br>
													<br>
													<h3> Comments</h3>
													<%
													CommentDAOImpl cdo = new CommentDAOImpl();
													ArrayList<Comment> list = new ArrayList<Comment>();
													list = cdo.getAllCommentsByPost(idp);
													for(Comment c : list){
											              UserDAOImpl udo = new UserDAOImpl();
											              User u1 = new User();
											              u1 = ud.getUserById(c.getIdUser());					
													%>

													<!-- COMMENT 1 - START -->
													<div class="media">
													<% Blob blob1 = u1.getPicture();
																if (blob1 != null) {
																      InputStream inputStream = blob1.getBinaryStream();
																      byte[] imageData = inputStream.readAllBytes();
																      String base64Image = Base64.getEncoder().encodeToString(imageData); %>
														<a class="pull-left" href="#"><img
															class="media-object"
															src="data:image/jpg;base64,<%=base64Image%>"
															alt=""></a>
															<%}%>
														<div class="media-body">
															<h4 class="media-heading"><%= u1.getFname()+" "+u1.getLname() %></h4>
															<b><p><%= c.getReply() %></p></b>
															<ul
																class="list-unstyled list-inline media-detail pull-left">
																<li><i class="fa fa-calendar"></i><%= c.getPostedAt() %></li>
																<li><i class="fa fa-thumbs-up"></i>13</li>
															</ul>
															<ul
																class="list-unstyled list-inline media-detail pull-right">									
															</ul>
														</div>
													</div>
													<!-- COMMENT 1 - END -->

													<% } %>
													
													<form method="post" action="comment">
														<h3 class="pull-left">New Comment</h3>
														
														<fieldset>
															<div class="row">
																<div class="col-sm-3 col-lg-1 hidden-xs">
																<% Blob blob2 = uc.getPicture();
																if (blob2 != null) {
																      InputStream inputStream = blob2.getBinaryStream();
																      byte[] imageData = inputStream.readAllBytes();
																      String base64Image = Base64.getEncoder().encodeToString(imageData); %>
																	<img class="img-responsive"
																		src="data:image/jpg;base64,<%=base64Image%>"
																		alt="">
																		<% } %>
																</div>
																<div class="form-group col-xs-12 col-sm-9 col-lg-10">
																<input type="text" name="idu" value="<%= uc.getId() %>" hidden>
																<input type="text" name="idp" value="<%= idp %>" hidden>
																	<textarea class="form-control" id="message" name="reply"
																		placeholder="Your message" required=""></textarea>
																</div>
															</div>
														</fieldset>
														<button type="submit" class="btn btn-normal pull-right">Submit</button>
													</form>

												</div>
											</div>
										</div>
									</section>


								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<%
			}catch(Exception e)
			{
				e.printStackTrace();
			}
					
			%>
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