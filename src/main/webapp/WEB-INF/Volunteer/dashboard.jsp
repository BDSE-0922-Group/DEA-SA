<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>
<link rel="stylesheet" href="css/style.css">
<main class="bg1 flex-col">
	<h1 class="dashboard-heading hFont text-align-center">Volunteer Dashboard</h1>
	<a href="#add-volunteer" class="add-volunteer">Add Volunteer</a>
	<div class="volunteer-dashboard">
		<div class="volunteer-box">
			<div class="profile-card pFont">
				<img src="images/ph.png" alt="Profile Picture">
				<h2>Volunteer 1</h2>
				<p>Information about Volunteer 1</p>
				<a class="card-link" href="#">View Details</a>
			</div>
		</div>
		<div class="volunteer-box">
			<div class="profile-card pFont">
				<img src="images/ph.png" alt="Profile Picture">
				<h2>Volunteer 2</h2>
				<p>Information about Volunteer 2</p>
				<a class="card-link" href="#">View Details</a>
			</div>
		</div>
		<div class="volunteer-box">
			<div class="profile-card pFont">
				<img src="images/ph.png" alt="Profile Picture">
				<h2>Volunteer 3</h2>
				<p>Information about Volunteer 3</p>
				<a class="card-link" href="#">View Details</a>
			</div>
		</div>
	</div>
	
</main>
<jsp:include page="../footer.jsp"></jsp:include>