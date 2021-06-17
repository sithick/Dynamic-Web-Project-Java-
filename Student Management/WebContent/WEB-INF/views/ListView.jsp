<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <div class="col-md-12 text-end">
      <form action="bulkUpload" method="post" enctype ="multipart/form-data">
        <button class="btn btn-outline-primary me-2"><input id="fileUpload" type="file" name="file" /><input type="submit" value="Bulk Upload"/></button>
        <button class="btn btn-outline-primary"><a href="addNew" style="text-decoration:none">Add New</a></button>
        </form>
      </div>
    </header>
  </div>
<!-- <div align="right"><a class="btn btn-primary" href="addNew" role="button">Add New</a></div> -->
<div align="center">
<caption><h2>List of Users</h2></caption>
        <table class="table table-success table-striped">
            
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
                <td><a style="text-decoration:none" href="edit?id=<c:out value='${userDetail.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a style="text-decoration:none" href="delete?id=<c:out value='${userDetail.id}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a style="text-decoration:none" href="show?id=<c:out value='${userDetail.id}' />">View</a>
				</td>
            </tr>
            
            </c:forEach>
                    
        </table>
    </div>
</body>
</html>