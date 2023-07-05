<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Donation" name="HTMLtitle" />
</jsp:include>

<main class="bg3 align-center justify-center">

	<div class="align-center error-popup">
		<span class="material-icons">error</span>
		<p id="error-text" class="pFont error-text"></p>
		<button class="btnAnimation icon material-icons"
			onclick="closeFormError()">close</button>
	</div>

	<section class="align-center flex-col form-card">
		<h3 class="form-heading">Donation Form</h3>
		<sf:form action="add_donation" class="align-center flex-col form" method="post" modelAttribute="donation">
			<div class="input-group">
				<sf:input required="true" type="text" name="name" autocomplete="off" path="name"
					class="input" /> <label class="user-label">Name</label>
			</div>
			<div class="flex">
				<div class="input-group">
					<sf:input required="true" type="text" name="currency" autocomplete="off" path="currency"
						class="input" id="currency" value="USD" /> <label class="user-label">Currency</label>
				</div>
				<div class="input-group">
					<sf:input required="true" type="text" name="amount" autocomplete="off" path="amount"
						class="input" id="donation-amount" /> <label class="user-label">Donation
						Amount</label>
				</div>
			</div>
			<div class="input-group">
				<sf:input required="true" type="text" name="contact" autocomplete="off" path="contact"
					class="input" /> <label class="user-label">Contact
					No.</label>
			</div>
			<div class="input-group">
				<sf:input required="true" type="text" name="accDetails" autocomplete="off" path="accDetails"
					class="input" /> <label class="user-label">Account
					Details</label>
			</div>

			<button type="submit" class="submit-btn">Donate</button>
		</sf:form>
	</section>

</main>

<jsp:include page="../footer.jsp"></jsp:include>