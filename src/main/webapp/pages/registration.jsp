<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Register to MSCE</title>
<!-- BOOTSTRAP STYLES-->
<link href="pages/assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="pages/assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="pages/assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

</head>
<body>
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
						<strong> New User ? Register Yourself </strong>
					</div>
					<div class="panel-body">
						<form:form commandName="user" method="post" action="registrationSubmit.ac">
							<br />
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="fa fa-circle-o-notch"></i></span>
								<form:input path="firstName" class="form-control"
									placeholder="First Name" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-tag"></i></span>
								<form:input path="lastName" class="form-control"
									placeholder="Last Name" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon">@</span>
								<form:input path="email" class="form-control"
									placeholder="Your Email" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<form:password path="" class="form-control"
									placeholder="Enter Password" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<form:password path="password" class="form-control"
									placeholder="Retype Password" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon">@</span>
								<form:input path="phoneNum" class="form-control"
									placeholder="Your Contact Number" />
							</div>
							<%-- <div class="form-group input-group">
								<span class="input-group-addon">Date of Birth</span>
								<form:input path="dateOfBirth" class="form-control"
									placeholder="Your Date of Birth" />
							</div> --%>
							<div class="form-group input-group">
								<span class="input-group-addon">Registering As...</span>
								<form:select path="userType">
									<form:option value="-1">--SELECT--</form:option>
									<form:option value="u">Normal User</form:option>
									<form:option value="o">Sensor Provider</form:option>
								</form:select>
							</div>
								<input type="submit" value="Register Me" class="btn btn-success ">
							<hr />
                                    Already Registered ?  <a
								href="login.ac">Login here</a>
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