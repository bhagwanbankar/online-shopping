<div class="container">

	<div class="row">

		<!-- This would display side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- this display actual products -->
		<div class="col-md-9">
			<!-- Add breadcrumb component -->
			<div class="row">

				<div class="col-lg-12"></div>
				<c:if test="${userClickAllProduts==true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</li>
					</ol>
				</c:if>
				
				<c:if test="${userClickCategoryProduts==true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ol>
				</c:if>
			</div>


		</div>
	</div>


</div>