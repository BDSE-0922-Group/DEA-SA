<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Partner Dashboard</h2>
	<nav class="align-center justify-start dashboard-nav hFont">
		<a href="post-meal"><button>Add a Meal</button></a>
	</nav>

	<div class="card-container justify-evenly flex-wrap">

		<c:if test="${not empty meals}">
			<c:forEach items="${meals}" var="m" varStatus="status">
				<c:set var="id" value="${m.id}"></c:set>

				<div class="card pFont">
					<img class="card-image" src="${m.photoImagePath}" alt="${m.photos}" />
					<h4 class="card-heading">M-${m.id}</h4>
					<h4 class="card-heading">${m.name}</h4>
					<p class="card-desc">${m.description}</p>
					<button id="openEditMeal${status.count}" class="card-link">Order</button>

					<dialog id="editMealM${status.count}" class="modal">

					<h3 class="modal-heading">
						Edit Meal
					</h3>
					<sf:form class="align-center flex-col form" method="post"
						action="edit_meal?mId=${m.id}" modelAttribute="meal">

						<div class="input-group">
							<input required="true" type="text" name="name" autocomplete="off"
								path="name" class="input" value="${m.name}" /> <label
								class="user-label">Meal Name</label>
						</div>
						<div class="input-group">
							<textarea rows="5" required="true" name="description"
								autocomplete="off" path="description"
								class="input input-textarea">${m.description }</textarea>
							<label class="user-label">Meal Description</label>
						</div>
						<div class="input-group">
							<label class="select-label">Meal Availability</label> <select
								class="input-select" name="availability">
								<c:if test="${m.availability eq true}">
									<option value="true" selected>Available</option>
									<option value="false">Not Available</option>
								</c:if>
								<c:if test="${m.availability eq false}">
									<option value="true" >Available</option>
									<option value="false" selected>Not Available</option>
								</c:if>
							</select>
						</div>

						<button type="submit" class="submit-btn">Save Meal</button>
					</sf:form>
					<button id="closeEditMeal${status.count}"
						class="material-icons modal-close">close</button>
					</dialog>

					<script>
						document.querySelector("#openEditMeal${status.count}").addEventListener("click", () => {
							document.querySelector("#editMealM${status.count}").showModal();
							});
						
						document.querySelector("#closeEditMeal${status.count}").addEventListener("click", () => {
							document.querySelector("#editMealM${status.count}").close();
							});
				</script>
				</div>



			</c:forEach>
		</c:if>
		<c:if test="${empty meals}">
			<p class="mealDisclaimer pFont text-align-center">No Meals are
				available</p>
		</c:if>

	</div>

</main>

<jsp:include page="../footer.jsp"></jsp:include>