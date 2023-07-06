<jsp:include page="../header.jsp">
	<jsp:param value="Member" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Partner Dashboard</h2>
	<nav class="align-center justify-start dashboard-nav hFont">
		<a href="post-meal"><button>Add a Meal</button></a>
	</nav>
	<div class="align-center flex-col dashboard-panel">
		<h3>Meals Available to Members</h3>
		<table class="dashboard-table">
			<thead class="hFont">
				<tr>
					<th>No.</th>
					<th>Meal</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<tr>
					<td>1</td>
					<td>Sample Meal</td>
					<td>Sample Description</td>
					<td>
						<button class="material-icons view">visibility</button>
						<button class="material-icons edit">edit</button>
						<button class="material-icons delete">delete</button>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Sample Meal</td>
					<td>Sample Description</td>
					<td>
						<button class="material-icons view">visibility</button>
						<button class="material-icons edit">edit</button>
						<button class="material-icons delete">delete</button>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Sample Meal</td>
					<td>Sample Description</td>
					<td>
						<button class="material-icons view">visibility</button>
						<button class="material-icons edit">edit</button>
						<button class="material-icons delete">delete</button>
					</td>
				</tr>
				<tr>
				</tr>
			</tbody>
		</table>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>