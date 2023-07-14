<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Add Event" name="HTMLtitle" />
</jsp:include>
	
<main class="bg3 align-center justify-center">

	<div class="align-center error-popup">
		<span class="material-icons">error</span>
		<p id="error-text" class="pFont error-text"></p>
		<button class="btnAnimation icon material-icons"
			onclick="closeFormError()">close</button>
	</div>

	<section class="align-center flex-col form-card">
		<h3 class="form-heading">Add Event</h3>
		<sf:form class="align-center flex-col form" action="post-events"
			method="post" modelAttribute="events" enctype="multipart/form-data">
			<div class="input-group">
				<sf:input required="true" type="text" name="name" autocomplete="off"
					path="name" class="input" />
				<label class="user-label">Event Name</label>
			</div>
			<div class="input-group">
				<sf:textarea rows="5" required="true" name="description"
					autocomplete="off" path="description" class="input input-textarea" />
				<label class="user-label">Event Description</label>
			</div>
			<div class="input-group">
			<sf:input required="true" type="text" name="venue" autocomplete="off"
					path="venue" class="input" />
				<label class="user-label">Venue</label> 
			</div>
			
			<div class="input-group">
			<sf:input id="dateSelector" required="true" type="date" name="date" autocomplete="off"
					path="date" class="input" onfocus="(this.type='date')" 
					onblur="if(!this.value)this.type='text'"/>
				<label class="user-label">Date</label> 
			</div>

			<button type="submit" class="submit-btn">Add Event</button>
		</sf:form>

	</section>

</main>

<jsp:include page="../footer.jsp"></jsp:include>