<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h1 class="dashboard-heading hFont text-align-center">Volunteer Dashboard</h1>
	
		<nav class="align-center justify-start dashboard-nav hFont">
				<button>Add an Event</button>
			</nav>
			<div class="align-center flex-col dashboard-panel">
				<h3>Events Available to Volunteers</h3>
				<table class="dashboard-table">
					<thead class="hFont">
						<tr>
							<th>No.</th>
							<th>Event Name</th>
							<th>Event Description</th>
							<th>Event Location</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody class="pFont">
						<tr>
							<td>1</td>
							<td>Sample Event</td>
							<td>Sample Event Description</td>
							<td>Sample Event Location</td>
							<td>
								<button class="material-icons view">visibility</button>
								<button class="material-icons edit">edit</button>
								<button class="material-icons delete">delete</button>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Sample Event</td>
							<td>Sample Event Description</td>
							<td>Sample Event Location</td>
							<td>
								<button class="material-icons view">visibility</button>
								<button class="material-icons edit">edit</button>
								<button class="material-icons delete">delete</button>
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td>Sample Event</td>
							<td>Sample Event Description</td>
							<td>Sample Event Location</td>
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
			</div>
	
</main>
<jsp:include page="../footer.jsp"></jsp:include>