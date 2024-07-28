<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/admin/layouts/taglib.jsp"%>
<!-- Modal Update-->
<div class="modal fade"  tabindex="-1" id="modalUpdate"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg ">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabell">Update</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"
                aria-label="Close"></button>
      </div>
      <div class="modal-body">
		<form action="${pageContext.request.contextPath}/admin/customer" method="post">
			<input type="hidden" name="userId" value="${tempUser.id}">
			<input type="hidden" name="command" value="UPDATE">
			<div class="col">
				<div class="row">
					<div class="col-6  ">
						<label for="fullnameUp" class="col-form-label">Fullname:</label> <input
							type="text" class="form-control" id="fullnameUp" name="fullnameUp"
							value="123">
					</div>
					<div class="col-6  ">
						<label for="emailUp" class="col-form-label">Email:</label> <input
							type="text" class="form-control" id="emailUp" name="emailUp"
							disabled>
					</div>
					<div class="col-6  ">
						<label for="phoneNumberUp" class="col-form-label">Phone number:</label> <input
							type="text" class="form-control" id="phoneNumberUp" name="phoneNumberUp"
							>
					</div>
					<div class="col-6  ">
						<label for="addressUp" class="col-form-label">Address:</label> <input
							type="text" class="form-control" id="addressUp" name="addressUp"
							>
					</div>
					<div class="col-6  ">
						<label for="usernameUp" class="col-form-label">User name:</label> <input
							type="text" class="form-control" id="usernameUp" name="usernameUp"
							disabled>
					</div>
					
					<div class="col-6  ">
						<label for="roleUp" class="col-form-label">Role:</label> 
						<div>
							<select name="roleUp" class="form-select" id="roleUp">
								<option value="-1">Choose type role</option>
								<option value="0">Admin</option>
								<option value="1">User</option>
							</select>
						</div>
					</div>
				</div>
			</div>
		
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Save
					changes</button>
			</div>
		</form>
      </div>

    </div>
  </div>
</div>
<!-- Modal Update-->