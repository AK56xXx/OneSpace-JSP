<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Udema a modern educational site template">
    <meta name="author" content="Ansonika">
    <title>UDEMA | Connexion</title>

    <!-- BASE CSS -->
    <link href="1/css/bootstrap.min.css" rel="stylesheet">
    <link href="1/css/style.css" rel="stylesheet">
	<link href="1/css/vendors.css" rel="stylesheet">
	<link href="1/css/icon_fonts/css/all_icons.min.css" rel="stylesheet">

    <!-- YOUR CUSTOM CSS -->
    <link href="1/css/custom.css" rel="stylesheet">

</head>

<body id="login_bg">
	
	<nav id="menu" class="fake_menu"></nav>
	
	<div id="preloader">
		<div data-loader="circle-side"></div>
	</div>
	<!-- End Preload -->
	
	<div id="login">
		<aside>
			<figure>
				<a href="index.html"><img src="1/img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
			</figure>
			<form action="login" method="post">
				
				<%
					String fullName = (String) session.getAttribute("user");
					if (fullName!=null){
					%>
						<script> window.location.replace("announcement.jsp"); </script>
					<%
					}
					%>
				
				
				<%
				String msg = (String) request.getAttribute("ERROR");
				if (msg!=null){
					out.print("<p style='color:red;'>"+msg+"</p>");
				}
				
				%> 
				
				
				<div class="form-group">
					<span class="input">
					<input class="input_field" type="text" autocomplete="off" name="username" required>
						<label class="input_label">
						<span class="input__label-content">Username</span>
					</label>
					</span>

					<span class="input">
					<input class="input_field" type="password" autocomplete="new-password" name="password" required>
						<label class="input_label">
						<span class="input__label-content">Password</span>
					</label>
					</span>
					<small><a href="recuperer.html"> Did you forget your password ?</a></small>
				</div>
				
				<input class="btn_1 rounded full-width add_top_30" type="submit" value="Login">
			</form>
			<div class="copy"></div>
		</aside>
	</div>
	<!-- /login -->
		
	<!-- COMMON SCRIPTS -->
    <script src="1/js/jquery-2.2.4.min.js"></script>
    <script src="1/js/common_scripts.js"></script>
    <script src="1/js/main.js"></script>
	<script src="assets/validate.js"></script>	
  
</body>
</html>