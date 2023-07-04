<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>
<link rel="stylesheet" href="css/style.css">
<main class="bg1 flex-col">
	<h1 class="dashboard-heading hFont text-align-center">Partners Dashboard</h1>
	<a href="#add-partner" class="add-partner">Add Partner</a>
	<div class="partner-dashboard">
		<div class="partner-box">
			<div class="profile-card pFont">
				<img src="images/ph.png" alt="Profile Picture">
				<h2>Partner 1</h2>
				<p>Information about Partner 1</p>
				<a class="card-link" href="#">View Details</a>
			</div>
		</div>
		<div class="partner-box">
			<div class="profile-card pFont">
				<img src="images/ph.png" alt="Profile Picture">
				<h2>Partner 2</h2>
				<p>Information about Partner 2</p>
				<a class="card-link" href="#">View Details</a>
			</div>
		</div>
		<div class="partner-box">
			<div class="profile-card pFont">
				<img src="images/ph.png" alt="Profile Picture">
				<h2>Partner 3</h2>
				<p>Information about Partner 3</p>
				<a class="card-link" href="#">View Details</a>
			</div>
		</div>
	</div>
	
</main>
<jsp:include page="../footer.jsp"></jsp:include>