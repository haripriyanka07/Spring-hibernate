<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Product</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product.css">
</head>
<body>
	<div id="main">
		<div id="header">
			<h2>Products</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Product</h3>
		<form:form action="saveProduct" modelAttribute="product" method="POST">
		
			<form:hidden path="id"/>
		
			<table id="savetable">
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name"/></td>
					</tr>
					<tr>
						<td><label>Rating:</label></td>
						<td><form:input path="rating"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
					
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/product/list">Back</a>
		</p>
	</div>
	
</body>
</html>