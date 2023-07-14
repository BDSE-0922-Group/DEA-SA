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
			<p class="data">${total_donation}&nbspDonations</p>
		</div>
		<div class="card">
			<h4 class="card-heading">Average Donation Amount</h4>
			<p class="data">USD $${average_donation_amount}</p>
		</div>
	</div>

	<div id="chart" class="justify-evenly">
		<div id="chartContainer"></div>
		<canvas id="pieChart"></canvas>
	</div>

	<nav class="align-center justify-start dashboard-nav hFont">
		<a href="donation"><button>Make a Donation</button></a>
	</nav>
	<div class="align-center flex-col dashboard-panel panel-table">
		<h3>Table of Recent Donations</h3>
		<table id="donationTable">
			<thead class="hFont">
				<tr>
					<th>Donation No.</th>
					<th>Payment Method</th>
					<th>Currency</th>
					<th>Amount</th>
					<th>Intent</th>
					<th>Payment Description</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<c:if test="${not empty recent}">
					<c:forEach items="${recent}" var="r" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${r.getMethod()}</td>
							<td>${r.getCurrency()}</td>
							<td>${r.getAmount()}</td>
							<td>${r.getIntent()}</td>
							<td>${r.getDescription()}</td>
							<td>${r.getDate()}</td>
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
<script>
	anychart.onDocumentReady(function() {
		anychart.theme(anychart.themes.darkEarth);
		// set the data
		var data = {
				
			header : [ "Date", "Amount" ],
			rows : [ 
					[ "January", 4500 ],
					[ "February", 8700 ],
					[ "March", 5750 ],
					[ "April", 3000 ], 
					[ "May", 6400 ],
					[ "June", 8500 ], 
					[ "July", 5000 ], 
					[ "August", 4300 ],
					[ "September", 3750 ],
					[ "October", 4000 ], 
					[ "November", 4200 ],
					[ "December", 7600 ]
				   ]
		};

		// create the chart
		var chart = anychart.column();

		// add data
		chart.data(data);

		// set the chart title
		chart.title("Total Donations for the year 2023");

		// draw
		chart.container("chartContainer");
		chart.draw();
	});
	
	var xValues = ["Reserve Fund", "Ingredients", "Operational Costs", "Services", "Miscellaneous"];
	var yValues = [15, 20, 25, 25, 15];
	var barColors = [
	  "#b91d47",
	  "#00aba9",
	  "#2b5797",
	  "#e8c3b9",
	  "#1e7145"
	];

	new Chart("pieChart", {
	  type: "pie",
	  data: {
	    labels: xValues,
	    datasets: [{
	      backgroundColor: barColors,
	      data: yValues
	    }]
	  },
	  options: {
	    title: {
	      display: true,
	      text: "Breakdown of Donations"
	    }
	  }
	});
</script>
<jsp:include page="../footer.jsp"></jsp:include>