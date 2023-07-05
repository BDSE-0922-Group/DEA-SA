<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>

<main class="bg3 align-center flex-col">
	<h2 class="dashboard-heading hFont">Donor Dashboard</h2>

	<div id="donorStats" class="justify-evenly">
		<div class="card">
			<h4 class="card-heading">Total of Donations Received</h4>
			<p class="data">USD $${total_donation_amount}</p>
		</div>
		<div class="card">
			<h4 class="card-heading">Total Donations Made</h4>
			<p class="data">${total_donation}Donations</p>
		</div>
		<div class="card">
			<h4 class="card-heading">Average Donation Amount</h4>
			<p class="data">USD $${average_donation_amount}</p>
		</div>
	</div>

	<div id="chartContainer" class="justify-evenly">
		<div></div>
		<div></div>
	</div>

	<nav class="align-center justify-start dashboard-nav hFont">
		<a href="donation"><button>Make a Donation</button></a>
	</nav>
	<div class="align-center flex-col dashboard-panel">
		<h3>Table of Recent Donations</h3>
		<table id="userManagement">
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
				<c:if test="${not empty recent}">
					<c:forEach items="${recent}" var="r" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${r.getName()}</td>
							<td>${r.getContact()}</td>
							<td>${r.getAmount()}</td>
							<td>${r.getCurrency()}</td>
							<td>${r.getAccDetails()}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty recent}">
						<tr>
							<td colspan="6">No donation made yet</td>
						</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>