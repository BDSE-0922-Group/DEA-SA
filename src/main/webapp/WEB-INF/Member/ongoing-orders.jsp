<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Member" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Ongoing Orders</h2>

	<div class="card-container justify-evenly flex-wrap">

		<c:if test="${not empty orders}">
			<c:forEach items="${orders}" var="o">
				<c:set var="id" value="${o.id}"></c:set>

				<c:if test="${o.status == 'ongoing'}">
					<div class="card pFont">
						<h4 class="card-heading">${o.mealId}</h4>
						<p class="card-desc">${o.description}</p>

						<c:forEach items="${ordMeals}" var="m">
							<c:set var="id" value="${m.id}"></c:set>

							<c:if test="${m.availability == 'true'}">
									<h4 class="card-heading">${m.name} ${m.id}</h4>
							</c:if>
						</c:forEach>
					</div>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${empty orders}">
			<p class="mealDisclaimer pFont text-align-center">No Orders are
				ongoing</p>
		</c:if>

	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>