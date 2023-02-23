<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:center">
<h1>EMPLOYEE SEARCH LIST SCREEN</h1>
</div>
<form:form action="${contextRoot}/addemployee" method="post" modelAttribute="addemployee">
Employee Number <form:input path="emp_id" placeholder="TextBox"/><br><br>
First Name <form:input path="firstName" placeholder="TextBox"/><br><br>
Last name <form:input path="last_name" placeholder="TextBox"/><br><br>
Mobile number<form:input path="mobile_num" placeholder="TextBox"/><br><br>
Date of birth <form:input path="dob" placeholder="TextBox"/><br><br>
Office mail <form:input path="office_mail" placeholder="TextBox"/><br><br>
Joining date <form:input path="doj" placeholder="TextBox"/><br><br>
Post <form:input path="post_name" placeholder="TextBox"/><br><br>
Basic pay <form:input path="basic_pay" placeholder="TextBox"/><br><br>
Pan Card no <form:input path="pan_num" placeholder="TextBox"/><br><br>
Permanent Address <form:input path="permanent_address" placeholder="TextBox"/><br><br>
gender<form:input path="gender" placeholder="TextBox"/><br><br>
Email personal <form:input path="email_id" placeholder="TextBox"/><br><br>
Employee level <form:input path="emp_level" placeholder="TextBox"/><br><br>
Blood Group <form:input path="blood_group" placeholder="TextBox"/><br><br>
House allowance <form:input path="house_allowance" placeholder="TextBox"/><br><br>
Aadhar card no <form:input path="aadhar_num" placeholder="TextBox"/><br><br>
Present Address <form:input path="present_address" placeholder="TextBox"/><br><br>
 
 
<button type="submit">Add employee</button>
 
 
</form:form>
 
</body>
</html>

