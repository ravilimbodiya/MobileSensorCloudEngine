<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
<link href="pages/assets/img/favicon.png" rel="shortcut icon" type="image/x-icon">
<!-- BOOTSTRAP STYLES-->
<link href="pages/assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="pages/assets/css/font-awesome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->
<link href="pages/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="pages/assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> <span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">MSCE</a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				Last access : 30 May 2014 &nbsp; <a href="logout.ac"
					class="btn btn-danger square-btn-adjust">Logout</a>
			</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center">
						<img src="pages/assets/img/find_user.png" class="user-image img-responsive" />
					</li>
					<li>
						<a class="active-menu" href="index.html"><i class="fa fa-dashboard fa-3x"></i>Dashboard</a>
					</li>
					<li>
						<a href="blank.html"><i class="fa fa-square-o fa-3x"></i>Request Sensor</a>
					</li>
					<li>
						<a href="blank.html"><i class="fa fa-square-o fa-3x"></i>Manage Sensor</a>
					</li>
					<li>
						<a href="blank.html"><i class="fa fa-square-o fa-3x"></i>Usage</a>
					</li>
					<li>
						<a href="blank.html"><i class="fa fa-square-o fa-3x"></i>Biling</a>
					</li>				
				</ul>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>User Dashboard</h2>
						<%@ page import="com.cloud.entity.User" %>
						<% User validUser = (User) session.getAttribute("validUser"); %>
						<h5>Welcome <%= validUser.getFirstName() %> <%= validUser.getLastName() %>, Love to see you back.</h5>
					</div>
				</div>				
				<!-- /. ROW  -->
				<hr />
				<!-- /. ROW  -->
				<div class="row">					
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">My Sensors</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table id="users" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>#</th>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Email</th>
												<th>Phone No.</th>
											</tr>
										</thead>										
									</table>
								</div>
							</div>
						</div>
					</div>					
				</div>
				
				<div class="row">
					<div class="col-md-8 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">Sensor Location</div>
							<div class="panel-body">
								<div id="sensor-map" style="height:340px;"></div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-12 col-xs-12">						
						<div class="panel panel-default">
							<div class="panel-heading">Active Sensors</div>
							<div class="panel-body">
								<div id="morris-sensor-chart"></div>
							</div>
						</div>
					</div>					
				</div>		
				
				<div class="row">
					<div class="col-md-6 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">Sensor Usage</div>
							<div class="panel-body">
								<div id="morris-usage-chart"></div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">Sensor Billing</div>
							<div class="panel-body">
								<div id="morris-billing-chart"></div>
							</div>
						</div>
					</div>					
				</div>								
			</div>		
			<!-- /. PAGE INNER  -->
		</div>
	</div>
	<!-- /. PAGE WRAPPER  -->	
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->	
	<!-- JQUERY SCRIPTS -->
	<script src="pages/assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="pages/assets/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="pages/assets/js/jquery.metisMenu.js"></script>
	<!-- MORRIS CHART SCRIPTS -->
	<script src="pages/assets/js/morris/raphael-2.1.0.min.js"></script>
	<script src="pages/assets/js/morris/morris.js"></script>
	<!-- DATA TABLE SCRIPTS -->
    <script src="pages/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="pages/assets/js/dataTables/dataTables.bootstrap.js"></script>        
	<!-- CUSTOM SCRIPTS -->
	<script src="pages/assets/js/user-custom.js"></script>
	<!-- GOOGLE MAP -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA_7yQeLqT_tn8Ln8IixcYhjuHhDbg7o1I" type="text/javascript"></script>		
</body>
</html>
