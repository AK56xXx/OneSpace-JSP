<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="dao.UserDAOImpl" %>
<%@ page import="models.File" %>
<%@ page import="dao.FileDAOImpl" %>
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
<link rel="stylesheet" href="css/storageStyle.css" />
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
				<div class="col-md-12">
					<div class="white_shd full margin_bottom_30">
						<div class="full graph_head">
							<div class="heading1 margin_0">
								<h2>Storage</h2>
							</div>
						</div>
						<div class="full progress_bar_inner">
							<div class="row">
								<div class="col-md-12">
						
									
									<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card-box">
                    <div class="row">
                        <div class="col-lg-6 col-xl-6">
                            <h4 class="header-title m-b-30">Files</h4>
                        </div>
                    </div>
                    
                            

                    <div class="row">
                    
                 <%
                    FileDAOImpl fd = new FileDAOImpl();
                    ArrayList<File> list = new ArrayList<File>();
                    list = fd.getAllFiles();
                    
                    for(File f : list) {
                    
                    
                    
                    
                    %> 
                        <div class="col-lg-3 col-xl-3">
                        
                  
                            <div class="file-man-box"><a href="" class="file-close"><i class="fa fa-times-circle"></i></a>
                                <div class="file-img-box"><img src="https://coderthemes.com/highdmin/layouts/assets/images/file_icons/pdf.svg" alt="icon"></div>
                                <a href="#" class="file-download"><i class="fa fa-download"></i></a>
                                <div class="file-man-title">
                                    <h5 class="mb-0 text-overflow"><%= f.getName() %> </h5>
                                    <p class="mb-0"><small>568.8 kb</small></p>
                                </div>
                            </div>
                            
                            
                            
                            
                        </div>
                
                   <% } %>  
                    </div>
                       
                </div>
            </div>
            <!-- end col -->
        </div>
        <!-- end row -->
    </div>
    <!-- container -->
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