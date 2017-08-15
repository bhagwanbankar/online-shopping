<div class="container">
	<!-- Breadcrum -->
	<div class="row">
		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>

			</ol>

		</div>
	</div>
	<div class="row">
		<!-- Display Image -->
		<div class="col-sm-4 col-xs-12">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpeg" class="img img-responsive" />
			</div>

		</div>

		<div class="col-sm-4 col-xs-12">
			<h3>${product.name}</h3>
			<hr />
			<p>${product.description}</p>
			<hr />
			<h4>
				Price:<Strong>&#8377; ${product.unitPrice} /-</Strong>
			</h4>
			<hr />
			<c:choose>

				<c:when test="${product.quantity <1}">

					<h6>
						Qty.Available : <span style="color: red">Out of Stock!</span>
					</h6>
					<a href="javascript:void(0)"
						class="btn btn-success disabled"> <strike><span
						class="glyphicon glyphicon-shopping-cart"> Add To Cart </span></strike></a>
					
				</c:when>
				<c:otherwise>

					<h6>Qty.Available : ${product.quantity}</h6>

					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"> <span class="glyphicon glyphicon-shopping-cart"> 
						Add To Cart</span>	</a>
				</c:otherwise>

			</c:choose>

			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
		</div>

	</div>


</div>