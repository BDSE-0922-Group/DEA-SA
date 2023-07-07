<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Member" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Pending Orders</h2>

	<div class="card-container justify-evenly flex-wrap">

		<c:if test="${not empty orders}">
			<c:forEach items="${orders}" var="o">
				<c:set var="id" value="${o.id}"></c:set>

				<c:if test="${o.status == 'ongoing'}">

					<div class="card pFont">
						<h4 class="card-heading">Meal
							Ordered&colon;&nbsp;M-${o.mealId}</h4>
						<p class="card-desc">
							Request to the kitchen&colon;<br>${o.description}</p>
						<span style="color: var(--secondary);">Date
							ordered&colon;&nbsp;${o.date }</span>

						<sf:form class="justify-center" modelAttribute="orders"
						method="post" action="order_status?oid=${o.id}">
							<button type="submit" class="submit-btn btnAnimation">Order Received</button>
						</sf:form>
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