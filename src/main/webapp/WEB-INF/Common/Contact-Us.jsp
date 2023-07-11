<jsp:include page="../header.jsp">
	<jsp:param value="Contact Us" name="HTMLtitle" />
</jsp:include>

<jsp:include page="../headerDivider.jsp"></jsp:include>

<main class="bg1 align-center flex-col">

	<div class="info-container">
		<h2 class="info-heading">Contact Us</h2>
		<p class="pFont info-paragraph">
			We value your feedback and are here to assist you. If you have any
			questions, concerns, or suggestions, please don't hesitate to get in
			touch with us.<br>Our dedicated customer support team is
			available to provide assistance and ensure a seamless experience with
			Merry Meals.
		</p>
	</div>

	<div class="info-card-container pFont">
		<div class="info-card">
			<img src="images/map.svg" alt="map graphic" width="100" height="100" />
			<h3 class="info-subHeading">Address</h3>
			<p class="info-paragraph">404 St. Uknwown Country</p>
		</div>
		<div class="info-card">
			<img src="images/email.svg" alt="map graphic" width="100"
				height="100" />
			<h3 class="info-subHeading">Email</h3>
			<p class="info-paragraph">meals.on.wheel@gmail.com</p>
		</div>
		<div class="info-card">
			<img src="images/call.svg" alt="map graphic" width="100" height="100" />
			<h3 class="info-subHeading">Phone</h3>
			<p class="info-paragraph">+63 1075693</p>
		</div>
	</div>

<!-- 	<section class="align-center flex-col form-card">
		<h3 class="form-heading text-align-center">Send us an Email</h3>
		<form class="align-center flex-col form" method="post">

			<div class="input-group">
				<input required="true" type="text" autocomplete="off" class="input" />
				<label class="user-label">Subject</label>
			</div>

			<div class="input-group">
				<input required="true" type="text" autocomplete="off" class="input" />
				<label class="user-label">Your Email</label>
			</div>

			<div class="input-group">
				<textarea rows="4" required="true" autocomplete="off" class="input"></textarea>
				<label class="user-label">Message</label>
			</div>

			<input type="submit" class="submit-btn btnAnimation" value="Submit"></input>
		</form>
	</section> -->

</main>

<jsp:include page="../footer.jsp"></jsp:include>