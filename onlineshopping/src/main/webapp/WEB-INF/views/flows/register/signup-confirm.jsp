<%@include file="../shared/flows-header.jsp"%>

<!-- Page Content -->
<div class="container">

	<div id="row">
		<!-- Column to display personal details -->
		<div class="col-sm-6">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
				<div class="panel-body">
					<!-- code to display personal details -->
					<div class="text-center">
					
					<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
					<h5>Email: ${registerModel.user.email}</h5>
					<h5>Contact number: ${registerModel.user.contactNumber }</h5>
					<h5>Role: ${registerModel.user.role }</h5>
					
					</div>
					
					
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of personal details -->
					<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
				</div>


			</div>


		</div>
		<!-- Column to display Billing details -->
		<div class="col-sm-6">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Billing Details</h4>
				</div>
				<div class="panel-body">
					<!-- code to display Billing details -->
					<div class="text-center">
					
					<h4>${registerModel.billing.addressLineOne}</h4>
					<h4>${registerModel.billing.addressLineTwo}</h4>
					<h4>${registerModel.billing.city} ${registerModel.billing.postalCode} </h4>
					<h4>${registerModel.billing.state} ${registerModel.billing.country} </h4>
										
					</div>
					
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of personal details -->
					<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
				</div>


			</div>


		</div>

	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="text-center">
				<!-- anchor to move Success Page -->
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirm</a>
			</div>

		</div>



	</div>


</div>

<%@include file="../shared/flows-footer.jsp"%>