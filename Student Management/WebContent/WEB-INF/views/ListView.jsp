<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
</head>
<body>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
          	<tr>
          		<th>Id</th>
          		<th>First Name</th>
          		<th>Last Name</th>
          		<th>Email Address</th>
          		<th>Gender</th>
          		<th>Country</th>
          		<th>City</th>
          		<th>Actions</th>
          	</tr>
          	<c:forEach var="userDetail" items="${lists}">
          	<tr>
                <td><c:out value="${userDetail.id}" /></td>
                <td><c:out value="${userDetail.firstName}" /></td>
                <td><c:out value="${userDetail.lastName}" /></td>
                <td><c:out value="${userDetail.email}" /></td>
                <td><c:out value="${userDetail.gender}" /></td>
                <td><c:out value="${userDetail.city}" /></td>
                <td><c:out value="${userDetail.country}" /></td>
                <td><a href="edit?id=<c:out value='${userDetail.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${userDetail.id}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="show?id=<c:out value='${userDetail.id}' />">View</a>
				</td>
            </tr>
            
            </c:forEach>
                    
        </table>
    </div>
</body>
</html>