<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">

		<c:if test="${not empty message}">
			<div class="col-xm-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>

			</div>

		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-body">
					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name</label>
							<div class="col-md-4">

								<sf:input type="text" path="name" placeholder="Product Name"
									class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />

							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name</label>
							<div class="col-md-4">

								<sf:input type="text" path="brand" placeholder="Brand Name"
									class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />

							</div>

						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								Product Description</label>
							<div class="col-md-8">

								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />

							</div>

						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Unit Price</label>
							<div class="col-md-4">

								<sf:input type="number" path="unitPrice"
									placeholder="Unit Price in &#8377" class="form-control" />

								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Available
								Quantity: </label>
							<div class="col-md-4">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity" class="form-control" />
							</div>
						</div>
						<!--  File element for file update -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image: </label>
							<div class="col-md-4">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Select
								Category: </label>
							<div class="col-md-4">

								<sf:select path="categoryId" id="categoryId"
									class="form-control" items="${categories}" itemLabel="name"
									itemValue="id" />

								<c:if test="${product.id==0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add
											Category</button>
									</div>
								</c:if>
							</div>

						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" value="Submit" id="submit"
									class="btn btn-primary" />
							</div>
						</div>
						<!-- Hidden Fields for product -->
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="supplierId" />
						<sf:hidden path="purchases" />
						<sf:hidden path="active" />
						<sf:hidden path="views" />

					</sf:form>

				</div>


			</div>


		</div>


	</div>


	<div class="row">

		<div class="col-xs-12"></div>

		<div class="col-xs-12">
			<div style="overflow: auto">
				<!--  Product tables for Admin -->
				<table id="adminProductTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>

				</table>
			</div>
		</div>
	</div>


	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal"><span>&times;</span></button>
					<h4 class=",odal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<!-- Category Form -->
					<sf:form modelAttribute="category" id="categoryForm" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
					
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4"> Category Name</label>
							<div class="col-md-8">
								<sf:input type="text" id="category_name" placeholder="Enter Category Name" path="name" class="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4"> Category Description</label>
							<div class="col-md-8">
								<sf:textarea cols="" rows="5" id="category_description" placeholder="Enter Category Description" path="description" class="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class=" col-md-offset-4 col-md-8">
								<input type="submit" class="btn btn-primary" value="Add Category"/>
							</div>
						</div>
					
					</sf:form>
				</div>
			
			</div>
		
		</div>
	
	
	</div>

</div>