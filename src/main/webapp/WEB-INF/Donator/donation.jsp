<jsp:include page="../header.jsp">
	<jsp:param value="Login" name="HTMLtitle" />
</jsp:include>

<div class="custom-shape-divider-top-1686716923">
	<svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg"
		viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path
			d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z"
			class="shape-fill"></path>
        </svg>
</div>

<main class="bg1 align-center justify-center">

	<div class="align-center error-popup">
		<span class="material-icons">error</span>
		<p id="error-text" class="pFont error-text"></p>
		<button class="btnAnimation icon material-icons"
			onclick="closeFormError()">close</button>
	</div>

	<section class="align-center flex-col form-card">
		<h3 class="form-heading">Donation Form</h3>
		<form id="registration" class="align-center flex-col form">
			<div id="currency-group" class="flex">
				<div class="input-group">
					<input id="currency" required="true" type="text" name="text"
						autocomplete="off" class="input"> <label
						class="user-label">Currency</label>
				</div>
				<div class="input-group">
					<input id="donation-amount" required="true" type="text" name="text"
						autocomplete="off" class="input"> <label
						class="user-label">Donation Amount</label>
				</div>
			</div>
			<div class="input-group">
				<input required="true" type="text" name="text" autocomplete="off"
					class="input"> <label class="user-label">Contact
					No.</label>
			</div>
			<div class="input-group">
				<input required="true" type="text" name="text" autocomplete="off"
					class="input"> <label class="user-label">Email
					Address</label>
			</div>

			<button type="submit" class="submit-btn">Donate</button>
		</form>
	</section>

</main>

<jsp:include page="../footer.jsp"></jsp:include>