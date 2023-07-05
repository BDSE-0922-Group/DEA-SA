<jsp:include page="../header.jsp">
	<jsp:param value="Member" name="HTMLtitle" />
</jsp:include>

<main class="bg3 align-center flex-col">
	<h2 class="dashboard-heading hFont text-align-center">Welcome to
		Meals on Wheels</h2>

	<p class="mealDisclaimer pFont text-align-center">Meals will be
		served frozen during week-ends or if your location is 10Km+ away</p>
	<a href="order" class="btnAnimation orderLink text-deco-none pFont">Place
		an order</a>
	<div class="card-container justify-evenly flex-wrap">
		<div class="card pFont">
			<img src="https://placehold.co/300x300" class="card-image" />
			<h4 class="card-heading">Sample Meal</h4>
			<p class="card-desc">Meal Description</p>
			<a href="" class="card-link">View Details</a>
		</div>

		<div class="card pFont">
			<img src="https://placehold.co/300x300" class="card-image" />
			<h4 class="card-heading">Sample Meal</h4>
			<p class="card-desc">Meal Description</p>
			<a href="" class="card-link">View Details</a>
		</div>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>