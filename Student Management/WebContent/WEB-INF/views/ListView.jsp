<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.student.models.RegistrationModel,java.util.*" %>
<%-- <%@ page import="javax.servlet.http.HttpSession" %>
<%

HttpSession s=request.getSession(false);  
String filePath=(String)session.getAttribute("filePath");
System.out.println(filePath);
%> --%>

<!DOCTYPE html>
<html>
<head>
<style>
th, td {
  padding: 15px;
  text-align: left;
}
.container{
	margin-top: 10px;
    margin-right: 0px;
    margin-left: 790px;
}
.addnew_button{
font-size: 17px;
}
</style>
<meta charset="ISO-8859-1">
<title>List Users</title>
</head>
<body>
<div class="container">
    <header>
      <div>
      <form action="bulkUpload" method="post" enctype ="multipart/form-data">
        <button ><input id="fileUpload" type="file" name="file" /><input type="submit" value="Bulk Upload"/></button>
        <button class="addnew_button"><a href="addNew" style="text-decoration:none">Add New</a></button>
        <a style="text-decoration:none" href="logout?id=<c:out value="${user}" />">Log Out</a>
        </form>
        
      </div>
    </header>
  </div>
<!-- <div align="right"><a class="btn btn-primary" href="addNew" role="button">Add New</a></div> -->
<div align="center">
<caption><h2>List of Users</h2></caption>
        <table>
            
          	<tr>
          		<th>Id</th>
          		<th>Profile</th>
          		<th>First Name</th>
          		<th>Last Name</th>
          		<th>Email Address</th>
          		<th>Gender</th>
          		<th>Country</th>
          		<th>City</th>
          		<th>Actions</th>
          	</tr>
          	<%-- <%
                ArrayList<RegistrationModel> listValues = (ArrayList<RegistrationModel>) request.getAttribute("list");
                System.out.println("-->"+listValues);
                %> --%>
          	<c:forEach var="userDetail" items="${list}">
          	<tr>
                <td><c:out value="${userDetail.id}" /></td>
                <%-- <td><c:out value="${userDetail.fileName}" /></td> --%>
                <td>
                <c:if test="${userDetail.fileName eq null}">
                <div class="text-center">
  					<img src="http://localhost:8080/Student_Management/images/no-image.jpg" style="height:75px;width:75px;" alt="pic">
					</div>
				</c:if>
				<c:if test="${userDetail.fileName ne null}">
                <div class="text-center">
  					<img src="http://localhost:8080/Student_Management/images/${userDetail.fileName}" style="height:75px;width:75px;" alt="pic">
					</div>
				</c:if>
				</td>
                <td><c:out value="${userDetail.firstName}" /></td>
                <td><c:out value="${userDetail.lastName}" /></td>
                <td><c:out value="${userDetail.email}" /></td>
                <td><c:out value="${userDetail.gender}" /></td>
                <td><c:out value="${userDetail.city}" /></td>
                <td><c:out value="${userDetail.country}" /></td>
                <td><a style="text-decoration:none" href="edit?id=<c:out value="${userDetail.id}" />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a style="text-decoration:none" href="delete?id=<c:out value="${userDetail.id}" />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a style="text-decoration:none" href="show?id=<c:out value='${userDetail.id}' />">View</a>
				</td>
            </tr>
            
            </c:forEach>
                    
        </table>
    </div>
</body>
</html>