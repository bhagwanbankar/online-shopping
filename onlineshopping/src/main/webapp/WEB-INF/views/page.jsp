<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap -readable theme CSS -->
<link href="${css}/bootstrap-readable-theme.min.css" rel="stylesheet">

<!-- Bootstrap Datatables theme CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<script>
	window.menu = '${title}';
	window.contextRoot='${contextRoot}';
</script>
</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<div class="content">
			<!-- Page Content -->
			<!-- Home page Content -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- Load when user click all products -->
			<c:if test="${userClickAllProduts==true or userClickCategoryProduts==true}">
				<%@include file="listProduct.jsp"%>
			</c:if>
			
			<!-- Load when user click single product -->
			<c:if test="${userClickShowProdut==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- Load when user click Manage products -->
			<c:if test="${userClickManageProducts==true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>

		</div>
		<!-- /.container -->

		<div class="container">
			<hr>
			<!-- Footer -->
			<%@include file="./shared/footer.jsp"%>
		</div>
		<!-- /.container -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- Jquery DataTables JavaScript -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Jquery DataTables Bootstrap JavaScript -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		<!-- Bootbox JavaScript -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Jquery validator JavaScript -->
		<script src="${js}/jquery.validate.js"></script>
		
		<!-- My app JavaScript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
