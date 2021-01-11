<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>

	<title>List of Products</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>

<body>

	<div id="main">
		<div id="header">
			<h2>Products Available</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="Add Product" 
					onclick="window.location.href='showForm';return false;" 
					class="add-button"/>
		
			<table id="productsList">
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
				<c:forEach var="temp" items="${products}">
				
					<c:url var="updateLink" value="/product/showFormForUpdate">
						<c:param name="productId" value="${temp.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/product/deleteProduct">
						<c:param name="productId" value="${temp.id}"/>
					</c:url>
				
					<tr>
						<td>${temp.name}</td>
						<td>${temp.rating}</td>
						<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>