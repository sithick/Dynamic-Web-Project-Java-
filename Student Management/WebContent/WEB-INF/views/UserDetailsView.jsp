<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<%-- <%
RegistrationModel model = (RegistrationModel) request.getAttribute("userDetail");
String fileName = model.getUploadModel().getFileName();
System.out.println(fileName);
%> --%>
<div align="center">
		<%-- <c:forEach var="usr" items="${userDetail}">
		
			<li>${usr}</li>
			
		</c:forEach> --%>
        <table border="1" cellpadding="5">
            <caption><h2>List of Details</h2></caption>
             <tr>
            	<th>File Name</th>
                <td>${userDetail.fileName}</td>
            </tr>
          	<tr>
          		<th>Profile</th>
          		<td><div class="text-center">
  					<img src="http://localhost:8080/Student_Management/images/${userDetail.fileName}" style="height:75px;width:75px;" class="rounded" alt="pic">
					</div>
				</td>
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
    <%String servletPath = request.getServletPath(); String com = "/show";%>
    <c:if test="${servletPath ne com }">
    <td><a href='admin'>Back</a></td>
    </c:if>
    
    <c:if test="${servletPath eq com }">
    <div style="align-content: center;"><a href='logout?id=<c:out value='${userDetail.id}'/>'>Logout</a></div>
    </c:if>s
</body>
</html>