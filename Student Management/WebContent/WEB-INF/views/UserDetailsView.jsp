<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Details</h2></caption>
          
            <tr>
            	<th>First Name</th>
                <td><c:out value="${userDetail.firstName}" /></td>
            </tr>
            <tr>
            	<th>Last Name</th>
                <td><c:out value="${userDetail.lastName}" /></td>
            </tr>
            <tr>
            	<th>Email Address</th>
                <td><c:out value="${userDetail.email}" /></td>
            </tr>
            <tr>
            	<th>Gender</th>
                <td><c:out value="${userDetail.gender}" /></td>
            </tr>
            <tr>
            	<th>City</th>
                <td><c:out value="${userDetail.city}" /></td>
            </tr>
            <tr>
            	<th>Country</th>
                <td><c:out value="${userDetail.country}" /></td>
            </tr>
                    
        </table>
    </div>  
    
    <%
    if(request.getServletPath().equals("/show")){
    	out.println("<center><a href='admin'>Back</a><center>");
    }
    else{
    	out.println("<center><a href='login'>Logout</a><center>");
    }
    
    %>
</body>
</html>