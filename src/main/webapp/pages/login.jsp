<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login to MSCE</title>
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
    <div class="container">
        <div class="row text-center ">
            <div class="col-md-12">
                <br /><br />
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
	                          	<span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
	                              <form:input type="text" class="form-control" path="userName" placeholder="Your Username" />
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