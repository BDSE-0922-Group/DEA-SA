<jsp:include page="../header.jsp">
	<jsp:param value="Donor" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Donor Dashboard</h2>

	<div id="donorStats" class="justify-evenly">
		<div class="card">
			<h4 class="card-heading">Total of Donations Recieved</h4>
			<p class="data">USD $8,000</p>
		</div>
		<div class="card">
			<h4 class="card-heading">Total Donations Made</h4>
			<p class="data">13,000 Donations</p>
		</div>
		<div class="card">
			<h4 class="card-heading">Average Donation Amount</h4>
			<p class="data">USD $1.625</p>
		</div>
	</div>

	<div id="chartContainer" class="justify-evenly">
		<div></div>
		<div></div>
	</div>

	<nav class="align-center justify-evenly dashboard-nav hFont">
		<button>Make a Donation</button>
	</nav>
	<div class="align-center flex-col dashboard-panel">
		<h3>Table of Recent Donations</h3>
		<table id="userManagement" class="panel-table">
			<thead class="hFont">
				<tr>
					<th>Donation No.</th>
					<th>Name</th>
					<th>Contact No.</th>
					<th>Amount</th>
					<th>Currency</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<tr>
					<td>1</td>
					<td>Sample User Full Name</td>
					<td>Sample Phone No.</td>
					<td>404</td>
					<td>Sample Currency</td>
					<td>sample@email.com</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Sample User Full Name</td>
					<td>Sample Phone No.</td>
					<td>404</td>
					<td>Sample Currency</td>
					<td>sample@email.com</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Sample User Full Name</td>
					<td>Sample Phone No.</td>
					<td>404</td>
					<td>Sample Currency</td>
					<td>sample@email.com</td>
				</tr>
				<tr>
				</tr>
			</tbody>
		</table>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>