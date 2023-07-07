<jsp:include page="../header.jsp">
	<jsp:param value="Member" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Admin Dashboard</h2>
	<nav class="align-center justify-start dashboard-nav hFont">
		<button>User Management</button>
		<button>Order Management</button>
	</nav>
	<div class="align-center flex-col dashboard-panel">
		<h3>User Management Table</h3>
		<table id="userManagement">
			<thead class="hFont">
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Username</th>
					<th>Email</th>
					<th>Role</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<tr>
					<td>1</td>
					<td>Sample User Full Name</td>
					<td>Sample Username</td>
					<td>sample@gmail.com</td>
					<td>Sample Role</td>
					<td><a href="" class="material-icons view">visibility</a> <a
						href="" class="material-icons edit">edit</a> <a href=""
						class="material-icons delete">delete</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td>Sample User Full Name</td>
					<td>Sample Username</td>
					<td>sample@gmail.com</td>
					<td>Sample Role</td>
					<td><a href="" class="material-icons view">visibility</a> <a
						href="" class="material-icons edit">edit</a> <a href=""
						class="material-icons delete">delete</a></td>
				</tr>
				<tr>
					<td>3</td>
					<td>Sample User Full Name</td>
					<td>Sample Username</td>
					<td>sample@gmail.com</td>
					<td>Sample Role</td>
					<td><a href="" class="material-icons view">visibility</a> <a
						href="" class="material-icons edit">edit</a> <a href=""
						class="material-icons delete">delete</a></td>
				</tr>
				<tr>
				</tr>
			</tbody>
		</table>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>