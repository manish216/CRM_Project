<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>customer form</title>
		
		<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
		<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>

</head>


	<body>

		<div id="wrapper">
		
			<div class= "header">
					<h2>CRM - Customer Relationship Manager</h2>
			</div>
			
			<div class="container">
				<h3>Save Container</h3>
				
				<form:form action="saveCustomer" modelAttribute="customer" method="POST">
				
				<!-- need to associate this data with customer id 
					so this form will get the data of the customer but when we update a given customer 
					the back end need to know which customer id is needed to be updated so for this reason
					we are writing the below given code to pass the customer id to backend controller which will set customer.setId() to update the database
				 -->
				 
				 	<form:hidden path="id"></form:hidden>
					
					<table>
						<tbody>
							<tr>
								<td><label>First name:</label></td>
								<td><form:input path="firstName"/></td>
							</tr>
							
							<tr>
								<td><label>last name:</label></td>
								<td><form:input path="lastName"/></td>
							</tr>
							
							<tr>
								<td><label>email:</label></td>
								<td><form:input path="email"/></td>
							</tr>
							
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="Save" class="Save"/></td>	
							</tr>
							
						</tbody>
					</table>
					
				</form:form>			
				
				<div style="clear; both;"></div>
					<p>
						<a href="${pageContext.request.contextPath}/customer/list">Back</a>
					</p>
			</div>
		</div>
	</body>
</html>