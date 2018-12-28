<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<!-- Page Content -->
<div class="container">

	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up- Address</h4>
				</div>
				<div class="panel-body">
					<sf:form
					method="POST" class="form-horizontal" id="billingForm" modelAttribute="billing">
					
					<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address Line 1</label>
							<div class="col-md-8">

								<sf:input type="text" path="addressLineOne" placeholder="Address Line 1"
									class="form-control" />
								<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>

						</div>
					
					<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address Line 2</label>
							<div class="col-md-8">

								<sf:input type="text" path="addressLineTwo" placeholder="Address Line 2"
									class="form-control" />
								<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
							</div>

						</div>
					
					<div class="form-group">
							<label class="control-label col-md-4" for="city">City</label>
							<div class="col-md-8">

								<sf:input type="text" path="city" placeholder="City"
									class="form-control" />
								<sf:errors path="city" cssClass="help-block" element="em" />
							</div>

						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="state">State</label>
							<div class="col-md-8">

								<sf:input type="text" path="state" placeholder="State"
									class="form-control" />
								<sf:errors path="state" cssClass="help-block" element="em" />
							</div>

						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country</label>
							<div class="col-md-8">

								<sf:input type="text" path="country" placeholder="Country"
									class="form-control" />
								<sf:errors path="country" cssClass="help-block" element="em" />
							</div>

						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Postal Code</label>
							<div class="col-md-8">

								<sf:input type="text" path="postalCode" placeholder="Pincode"
									class="form-control" />
								<sf:errors path="postalCode" cssClass="help-block" element="em" />
							</div>

						</div>
						
						<div class="form-group">
							<div class="col-md-8 col-md-offset-4">

							<button type="submit" class="btn btn-primary" name="_eventId_personal">
							
							<span class="glyphicon glyphicon-chevron-left"></span>Previous 
							
							</button>	
							
							<button type="submit" class="btn btn-primary" name="_eventId_confirm">
							
							Next <span class="glyphicon glyphicon-chevron-right"></span>
							
							</button>							
							</div>

						</div>
						
					
					</sf:form>
				
				</div>

			</div>

		</div>

	</div>

</div>

<%@include file="../shared/flows-footer.jsp"%>