<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<title>List Customers</title>
		<!-- reference our style sheets -->
		
		<link type="text/css"
			  rel = "stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css" />	  
	</head>
	
	<body>
		<div id="wrapper">
			<div id ="header">
				<h2>CRM - Customer Relationship Manager</h2>
				<p></p>
			</div>
			
			<div id ="container">
				<div id="content">
				
					<!-- Add a Button -->
					<input type ="button" value ="Add Customer"
							onclick ="window.location.href='showFormForAdd'; return false;"
							class="add-button"
					/>
					<!-- add html table -->
					<table>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
						
						<!-- Loop over and print our customer  -->
						<c:forEach var="tempCustomer" items="${customers}">
							<!-- Construct an update link with customer ID  -->
							
								<c:url var="updateLink" value ="/customer/showFormForUpdate">
									<c:param name="customerId" value="${tempCustomer.id}"></c:param>
								</c:url>
								
								<!-- Construct an delete link with customer ID  -->
							
								<c:url var="deleteLink" value ="/customer/delete">
									<c:param name="customerId" value="${tempCustomer.id}"></c:param>
								</c:url>
								
								
							<tr>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>
								
								<td>
									<!-- display the update link  -->
									<a href="${updateLink}">Update</a>
									|
									<a href="${deleteLink}"
									onClick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</td>
							</tr>
						
						</c:forEach>
						
						
					</table>
				</div>
			</div>
		</div>
	</body>
</html>