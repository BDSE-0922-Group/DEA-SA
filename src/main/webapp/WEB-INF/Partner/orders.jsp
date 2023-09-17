<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Orders" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Pending Orders</h2>
	
	<nav class="align-center justify-start dashboard-nav hFont">
		<a href="post-meal"><button>Add a Meal</button></a>
		<a href="orders"><button>Order list</button></a>
	</nav>
	
	<div class="card-container justify-evenly flex-wrap">

		<c:if test="${not empty orders}">
			<c:forEach items="${orders}" var="o">

				<c:if test="${o.status == 'ongoing' || o.status == 'delivery'}">
				
					<div class="card pFont">
						<h4 class="card-heading">Meal
							Ordered&colon;&nbsp;M-${o.getMeal().getName()}</h4>
						<c:if test="${ not empty o.description }">
							<p class="card-desc">
							Request to the kitchen&colon;<br>${o.description}</p>
						</c:if>
							<br>
							<p class="card-desc">
							Recipient&colon;<br>${o.getUser().getName()}</p>
							<p class="card-desc">
							Address&colon;<br>${o.address}</p>
						<span style="color: var(--secondary);">Date
							ordered&colon;&nbsp;${o.date }</span>

						<button type="submit" class="submit-btn btnAnimation" style="margin: auto; width: 80%;"
							onclick="window.location.href='order_prepared?${o.id}'">Order
							Prepared</button>
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