<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="models.User"%>
<%@ page import="models.Message"%>
<%@ page import="dao.UserDAOImpl"%>
<%@ page import="dao.MessageDAOImpl"%>
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
<link rel="stylesheet" href="css/messageStyle.css" />
<!-- calendar file css -->
<link rel="stylesheet" href="js/semantic.min.css" />
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->

<style>
  .scrollable-div {
    height: 700px; /* Set the desired height */
    width: 1000px; /* Set the desired width */
    overflow: auto; /* Add scrollbars when content exceeds the dimensions */
  }
</style>
</head>
<body class="inner_page contact_page">
	<%
	try {
	//get user of the session
	User uc = (User) session.getAttribute("user");
	int idu = uc.getId();

	//get contact(user) id  param
	String ct = (String)request.getParameter("idc");
	if (ct != null && !ct.isEmpty()) {
			int idc = Integer.valueOf(ct);
	
	
    

	//get contact object
	UserDAOImpl ud = new UserDAOImpl();
	User contact = new User();
	contact = ud.getUserById(idc);
	%>
	<div class="full_container">
		<div class="inner_container">
			<%@ include file="menu.jsp"%>
			<!-- right content -->
			<div id="content">
				<div class="midde_cont">
					<div class="container-fluid">
						<div class="row column_title">
							<div class="col-md-12">
								<div class="page_title">
									<h2>Messages</h2>
								</div>
							</div>
						</div>

						<div class="main-wrapper">



							<div class="row">
								<div class="col-md-12 col-12 card-stacked">
									<div class="card shadow-line mb-3 chat">



										<form method="post" action="message">
											<div class="col-md-8 col-12 card-stacked">
												<div class="card shadow-line mb-3 chat chat-panel">
													<div class="p-3 chat-header">
														<div class="d-flex">
															<div class="w-100 d-flex pl-0">
															 <% Blob blob = contact.getPicture();
																if (blob != null) {
																      InputStream inputStream = blob.getBinaryStream();
																      byte[] imageData = inputStream.readAllBytes();
																      String base64Image = Base64.getEncoder().encodeToString(imageData); %>
																<img
																	class="rounded-circle shadow avatar-sm mr-3 chat-profile-picture"
																	src="data:image/jpg;base64,<%=base64Image%>" alt="">
																	<% } %>
																<div class="mr-3">
																	<a href="!#">
																		<p class="fw-400 mb-0 text-dark-75"><%=contact.getFname() + " " + contact.getLname()%>
																		</p>
																	</a>
																	<p class="sub-caption text-muted text-small mb-0">
																		<i class="la la-clock mr-1"></i>last seen today at
																		09:15 PM
																	</p>
																</div>
															</div>

														</div>
													</div>
													<div
														class="d-flex flex-row mb-5 navigation-mobile scrollable-chat-panel chat-panel-scroll">
														<div class="scrollable-div">


														<div class="w-100 p-3">
										

															<%
															MessageDAOImpl dm = new MessageDAOImpl();
															ArrayList<Message> list = new ArrayList<Message>();
															list = dm.getAllMessagesBySenderAndReceiver(uc.getId(), idc);

															for (Message m : list) {
																User x = new User();
																x = ud.getUserById(m.getSender());
															%>

															<%-- Display message sent by the logged-in user --%>

															<div class="left-chat-message fs-13 mb-2">
													
																<p class="mb-0 mr-3 pr-4"><p><%=x.getFname() + " " + x.getLname() + "	: 	" + m.getMessage()%></p>
																<div class="message-options">
																	<div class="message-time">06:15</div>
																	<div class="message-arrow">
																		<i class="text-muted la la-angle-down fs-17"></i>
																	</div>
																</div>


															</div>




															<%
															}
															%>







														</div>
														</div>
													</div>

													<div class="chat-search pl-3 pr-3">

														<div class="input-group">
															<input type="text" name="idc" value="<%=idc%>" hidden>
															<input type="text" name="idu" value="<%=idu%>" hidden>
															<input type="text" class="form-control" name="msg"
																placeholder="Write a message" required>
														</div>


													</div>

													<input type="submit" value="Send" hidden>

												</div>
											</div>

										</form>


									</div>
								</div>
							</div>

							<script
								src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
								type="text/javascript"></script>
							<script
								src="https://cdnjs.cloudflare.com/ajax/libs/jquery.perfect-scrollbar/0.6.7/js/min/perfect-scrollbar.jquery.min.js"
								type="text/javascript"></script>


						</div>
						<!-- footer -->

					</div>
					<!-- end dashboard inner -->
				</div>
			</div>
		</div>

		<!-- jQuery -->
		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/popper.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!-- wow animation -->
		<script src="js/animate.js" type="text/javascript"></script>
		<!-- select country -->
		<script src="js/bootstrap-select.js" type="text/javascript"></script>
		<!-- owl carousel -->
		<script src="js/owl.carousel.js" type="text/javascript"></script>
		<!-- chart js -->
		<script src="js/Chart.min.js" type="text/javascript"></script>
		<script src="js/Chart.bundle.min.js" type="text/javascript"></script>
		<script src="js/utils.js" type="text/javascript"></script>
		<script src="js/analyser.js" type="text/javascript"></script>
		<!-- nice scrollbar -->
		<script src="js/perfect-scrollbar.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			var ps = new PerfectScrollbar('#sidebar');
			(function($) {
				"use strict";
				$('.scrollable-chat-panel').perfectScrollbar();
				var position = $(".chat-search").last().position().top;
				$('.scrollable-chat-panel').scrollTop(position);
				$('.scrollable-chat-panel').perfectScrollbar('update');
				$('.pagination-scrool').perfectScrollbar();

				$('.chat-upload-trigger').on(
						'click',
						function(e) {
							$(this).parent().find('.chat-upload').toggleClass(
									"active");
						});
				$('.user-detail-trigger').on(
						'click',
						function(e) {
							$(this).closest('.chat').find('.chat-user-detail')
									.toggleClass("active");
						});
				$('.user-undetail-trigger').on(
						'click',
						function(e) {
							$(this).closest('.chat').find('.chat-user-detail')
									.toggleClass("active");
						});
			})(jQuery);
		</script>
		<!-- custom js -->
		<script src="js/custom.js" type="text/javascript"></script>
		<!-- calendar file css -->
		<script src="js/semantic.min.js" type="text/javascript"></script>
		<script type="text/javascript"></script>
	</div>
	<%
	}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	%>
</body>
</html>