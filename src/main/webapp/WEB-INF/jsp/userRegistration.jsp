<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form:form commandName="user" action="register.action" method="POST">
		First Name:<br />
		<form:input path="firstName" />
		<form:errors path="firstName"></form:errors>
		<br />
		<br />
		Last Name:<br />
		<form:input path="lastName" />
		<form:errors path="lastName"></form:errors>
		<br />
		<br />
		Email:<br />
		<form:input path="email" />
		<form:errors path="email"></form:errors>
		<br />
		<br />
		Password:<br />
		<form:password path="password" />
		<form:errors path="password"></form:errors>
		<br />
		<br />
		Phone Number:<br />
		<form:input path="phoneNum" />
		<form:errors path="phoneNum"></form:errors>
		<br />
		<br />
		Birthdate (DD/MM/YYYY)<br />
		<form:input path="dateOfBirth" />
		<form:errors path="dateOfBirth"></form:errors>
		<br />
		<br />
		Signing Up As...<br />
		<form:select id="userType" path="userType">
			<form:option value="u" label="User" />
			<form:option value="o" label="Sensor Owner" />
		</form:select>
		<form:errors path="userType"></form:errors>
		<br />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>