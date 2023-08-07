<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  
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
			<c:forEach items="${meals}" var="m">
				<c:set var="id" value="${m.id}"></c:set>

				<div class="card pFont">
					<img class="card-image" src="${m.photoImagePath}" alt="${m.photos}" />
					<h4 class="card-heading">M-${m.id}</h4>
					<h4 class="card-heading">${m.name}</h4>
					<p class="card-desc">${m.description}</p>
					<a href="order" class="card-link">Order</a>
				</div>

				<dialog id="editProfileModal" class="modal"
					style="margin-top: -7rem;" open>

				<div class="align-center error-popup">
					<span class="material-icons">error</span>
					<p id="error-text" class="pFont error-text"></p>
					<button class="btnAnimation icon material-icons"
						onclick="closeFormError()">close</button>
				</div>

				<h3 class="modal-heading">Edit Profile</h3>
				<sf:form id="editMeal" class="align-center flex-col form"
					action="" method="post">

					<div class="input-group">
						<sf:input required="true" type="text" path="name"
							autocomplete="off" class="input" />
						<label class="user-label">Meal Name</label>
					</div>

					<button class="submit-btn btnAnimation"
						style="background-color: var(--success);" type="submit">Save</button>
				</sf:form>
				<button id="closeEditMeal" class="material-icons modal-close">close</button>
				</dialog>
			</c:forEach>
		</c:if>
		<c:if test="${empty meals}">
			<p class="mealDisclaimer pFont text-align-center">No Meals are
				available</p>
		</c:if>

	</div>

</main>

<jsp:include page="../footer.jsp"></jsp:include>