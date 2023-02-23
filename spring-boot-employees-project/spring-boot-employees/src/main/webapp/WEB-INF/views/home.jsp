<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense tracker home Page</title>
<style type="text/css">
<div style="text-align:center">
table{width:600px}
 
td{border:1px solid black; padding:5px; border-collapse: collapse;text-align: center}
th{width:1000px; border:1px solid black }
span{color:green; font-weight: bold; font-family: sans-serif;font-size: large;}
</style>
</head>
<body>
<div style="text-align:center">
<h1>EMPLOYEE SEARCH LIST SCREEN</h1>
</div>
<%-- <h2><span>${message}</span></h2> --%>
 
 <form action="${contextRoot}/search" method="post">
Enter ID: <input name="id"/>
Enter Name: <input name="name"/>
<button type="submit">Search</button>
</form>
 
<span><a href="${contextRoot}/addemployee">ADD AN EMPLOYEE</a></span>
<br></br>
<table>
<tr>
<th bgcolor=#A9DFBF>EMPLOYEE</th>
<th bgcolor=#A9DFBF>CONTACT</th>
<th bgcolor=#A9DFBF>LEVEL AND POST</th>
<th bgcolor=#A9DFBF>ACTION</th>
<!-- <th>EMPLOYEE PHOTO</th> -->
</tr>
<c:forEach var="employee" items="${employees}">
<tr>
<td><h4>${employee.firstName} ${employee.last_name}</h4><br>#${employee.emp_id}</td>
<td><p>${employee.mobile_num}<br>${employee.email_id}</p></td>
<td>${employee.emp_level}<br>
${employee.post_name}
</td>
<td><a href="${contextRoot}/addemployee/${employee.emp_id}">Edit </a> / <a href="/${employee.emp_id}">Delete </a>/<a href="${contextRoot}/history/${employee.emp_id}">History</a></td>
<!-- <td>substitute for a photo</td> -->
</tr>
</c:forEach>
</table>
</div> 

<div><a href="${contextRoot}/exportUsers">Download CSV</a></div>


</body>
</html>

