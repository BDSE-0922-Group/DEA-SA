<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>
<link rel="stylesheet" href="css/style.css">
<main class="bg1 flex-col">
	<section class="contact">
		<div class="cont-content">
			<h2 class="text-align-center hFont dashboard-heading"> CONTACT US </h2>
			<p class="pFont">We value your feedback and are here to assist you. If you have any questions, concerns, or suggestions,
                please don't hesitate to get in touch with us. <br><br>Our dedicated customer support team is available to
                provide assistance and ensure a seamless experience with Merry Meals.
          </p>
		</div>
		<div class="contactContainer">
			<div class="contactInfo">
				<div class="box">
					<div class="icon"><img src="images/address.svg" width="40" height="40"></div>
						<div class="text">
							<h3 class="hFont"> Address</h3>
							<p class="pFont"> 404 Address st. Country</p> 
						</div>
					</div>
					
				<div class="box">
					<div class="icon"><img src="images/email.svg" width="40" height="40"></div>
						<div class="text">
							<h3 class="hFont"> Email</h3>
							<p class="pFont"> meals.on.wheels@gmail.com</p> 
						</div>
					</div>
					
				<div class="box">
					<div class="icon"><img src="images/phone.svg" width="40" height="40"></div>
						<div class="text">
							<h3 class="hFont"> Phone</h3>
							<p class="pFont"> +63 1075693</p> 
						</div>
					</div>					
			</div>
			<div class="contactForm">
				<form>
					<h2 class="text-align-center hFont dashboard-heading">Send Message</h2>
					<div class="cont-inputBox">
						<input type="text" name="" required="required">
						<span class="pFont">Full Name</span>
					</div>
					
					<div class="cont-inputBox">
						<input type="text" name="" required="required">
						<span class="pFont">Email</span>
					</div>
					
					<div class="cont-inputBox">
						<textarea required="required"></textarea>
						<span class="pFont">Type Your Message</span>
					</div>
					
					<div class="cont-inputBox">
						<input class="card-link" type="submit" name="" value="Send Message">
					</div>
				</form>
			</div>
		</div>
	</section>
</main>
<jsp:include page="../footer.jsp"></jsp:include>