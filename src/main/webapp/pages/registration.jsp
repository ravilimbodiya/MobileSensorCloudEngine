<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Register to MSCE</title>
<link href="pages/assets/img/favicon.png" rel="shortcut icon" type="image/x-icon">
<!-- BOOTSTRAP STYLES-->
<link href="pages/assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="pages/assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="pages/assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>
<body>
	<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">MSCE</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">MSCE</a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				<a href="login.ac" class="btn btn-danger square-btn-adjust">Login</a>
				&nbsp; <a href="registration.ac"
					class="btn btn-danger square-btn-adjust">Register</a>
			</div>
		</nav>
	<div class="container">
		<div class="row text-center  ">
			<div class="col-md-12">
				<br />
				<br />
				<h2>MSCE : Register</h2>

				<h5>( Register to access UV Sensor data )</h5>
				<br />
			</div>
		</div>
		<div class="row">

			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> New User? Register Yourself</strong>
					</div>
					<div class="panel-body">
						<form:form commandName="user" method="post" action="registrationSubmit.ac">
							<br />
							<form:errors path="firstName" cssClass="alert-danger form-control"/>
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="fa fa-circle-o-notch"></i></span>
								<form:input path="firstName" class="form-control" placeholder="First Name" />
							</div>
							<form:errors path="lastName" cssClass="form-control alert-danger"/>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-tag"></i></span>
								<form:input path="lastName" class="form-control" placeholder="Last Name" />
							</div>
							<form:errors path="password" cssClass="form-control alert-danger"/>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<form:password path="" class="form-control" placeholder="Enter Password" />
							</div>
							<form:errors path="password" cssClass="form-control alert-danger"/>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<form:password path="password" class="form-control" placeholder="Retype Password" />
							</div>
							<form:errors path="email" cssClass="form-control alert-danger"/>
							<div class="form-group input-group">
								<span class="input-group-addon">@</span>
								<form:input path="email" class="form-control" placeholder="Your Email" />
							</div>
							<form:errors path="phoneNum" cssClass="form-control alert-danger"/>
							<div class="form-group input-group">
								<span class="input-group-addon">@</span>
								<form:input path="phoneNum" class="form-control" placeholder="Your Contact Number" />
							</div>						
							<form:errors path="userType" cssClass="form-control alert-danger"/>
							<div class="form-group input-group">
								<span class="input-group-addon">Registering As...</span>
								<form:select path="userType" class="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:option value="user">Normal User</form:option>
									<form:option value="provider">Sensor Provider</form:option>
								</form:select>
							</div>
								<input type="submit" value="Register Me" class="btn btn-success ">
								<hr />
                                Already Registered ?  <a href="login.ac">Login here</a>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="pages/assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="pages/assets/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="pages/assets/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="pages/assets/js/custom.js"></script>

</body>
</html>