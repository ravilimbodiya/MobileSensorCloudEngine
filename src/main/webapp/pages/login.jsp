<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login to MSCE</title>
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
        <div class="row text-center ">
            <div class="col-md-12">
                <br /><c:choose>
					<c:when test="${requestScope.errMsg != '' && requestScope.errMsg != null}">
						<div class="alert alert-danger" id="msg">
                    		${errMsg}
                		</div>
					</c:when>
					<c:when test="${requestScope.sucMsg != '' && requestScope.sucMsg != null}">
						<div class="alert alert-success" id="msg">
                    		${sucMsg}
                		</div>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose><br />
                <h2> MSCE : Login</h2>               
                <h5>( Login to access UV sensor data )</h5>
                <br />
            </div>
        </div>
        <div class="row ">               
	    	<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	            			<strong>Enter Details To Login </strong>  
	                </div>
	                <div class="panel-body">
	                    <form:form role="form" action="loginSubmit.ac" commandName="user" method="post">
	                      	<br />
	                          <div class="form-group input-group">
	                          	<span class="input-group-addon"><i class="fa fa-at"  ></i></span>
	                              <form:input type="text" class="form-control" path="email" placeholder="Your Email" />
	                          </div>
	                          <div class="form-group input-group">
	                          	<span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
	                              <form:password type="password" class="form-control"  path="password" placeholder="Your Password" />
	                          </div>
	                          <div class="form-group">
	                           <label class="checkbox-inline">
	                               <input type="checkbox"/> Remember me
	                           </label>
	                           <span class="pull-right">
	                           		<a href="#" >Forget password?</a> 
	                           </span>
	                          </div>	                              
	                           <input type="submit" value="Login Now" class="btn btn-primary ">
	                          <hr />
	                          Not register?	<a href="registration.ac">click here </a>
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