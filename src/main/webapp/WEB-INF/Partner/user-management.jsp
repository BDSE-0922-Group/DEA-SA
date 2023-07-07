<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div id="userManagement" class="align-center flex-col dashboard-panel">
	<h3>User Management Table</h3>
	<table id="userManagementTable" class="hFont">
		<thead>
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Username</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Address</th>
				<th>Gender</th>
				<th>Role</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.name}</td>
					<td>${user.userName}</td>
					<td>${user.email}</td>
					<td>${user.mobile}</td>
					<td>${user.address}</td>
					<td>${user.gender}</td>
					<td>
						<ul>
							<c:forEach items="${user.roles}" var="role">
								<li>${role.name}</li>
							</c:forEach>
						</ul>
					</td>
					<td>
						<a href="/admin/view-user/${user.id}" class="material-icons view">visibility</a>
						<a href="/admin/edit-user/${user.id}" class="material-icons edit">edit</a>
						<a href="/admin/delete-user/${user.id}" class="material-icons delete">delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	
<!-- TODO: user management view modal -->
<div id="viewUserModal" class="modal">
	<div class="modal-content">
		<h3>User Details</h3>
		<p>User ID: ${user.id}</p>
		<p>Name: ${user.name}</p>
		<p>Username: ${user.userName}</p>
		<p>Email: ${user.email}</p>
		<p>Mobile: ${user.mobile}</p>
		<p>Address: ${user.address}</p>
		<p>Gender: ${user.gender}</p>
		<p>Role: </p>
			<ul>
				<c:forEach items="${user.roles}" var="role">
					<li>${role.name}</li>
				</c:forEach>
			</ul>
		<button onclick="closeModals()">Close</button>
	</div>
</div>
	
<!-- TODO: user management update/edit modal -->
<div id="editUserModal" class="modal">
	<div class="modal-content">
		<h3>Edit User</h3>
		<sf:form id="editUserForm" modelAttribute="user" action="edit-user/${user.id}" method="post">
			<label for="id">ID:</label>
			<sf:input path="id" id="id" disabled="true" />
            
			<label for="name">Name:</label>
			<sf:input path="name" id="name" required="true" />
            
			<label for="userName">Username:</label>
			<sf:input path="userName" id="userName" required="true" />
            
			<label for="email">Email:</label>
			<sf:input path="email" id="email" required="true" />
            
			<label for="mobile">Mobile:</label>
			<sf:input path="mobile" id="mobile" required="true" />
            
			<label for="address">Address:</label>
			<sf:input path="address" id="address" required="true" />
            
			<label for="gender">Gender:</label>
			<sf:input path="gender" id="gender" required="true" />
            
			<button type="submit">Save</button>
			<button onclick="closeModals()">Cancel</button>
		</sf:form>
	</div>
</div>
	
<!-- TODO: user management delete modal -->
<div id="deleteUserModal" class="modal">
	<div class="modal-content">
		<h3>Delete User</h3>
		<p>Are you sure you want to delete the user ${user.name}?</p>
		<sf:form id="deleteUserForm" action="delete-user/${user.id}" method="post">
			<button type="submit">Delete</button>
			<button onclick="closeModals()">Cancel</button>
		</sf:form>
	</div>
</div>