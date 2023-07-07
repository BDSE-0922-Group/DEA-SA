<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>

<main class="bg3 align-center flex-col">

	<h2 class="dashboard-heading hFont text-align-center">Welcome to
		Meals on Wheels</h2>

	<p class="mealDisclaimer pFont text-align-center">Meals will be
		served frozen during week-ends or if your location is 10Km+ away</p>
	<a href="order" class="btnAnimation orderLink text-deco-none pFont">Place
		an order</a>

	<div class="card-container justify-evenly flex-wrap">

		<c:if test="${not empty meals}">
			<c:forEach items="${meals}" var="m">
				<c:set var="id" value="${m.id}"></c:set>

				<c:if test="${m.availability == 'true'}">
					<div class="card pFont">
						<img class="card-image" src="${m.photoImagePath}" alt="${m.photos}" />
						<h4 class="card-heading">M-${m.id}</h4>
						<h4 class="card-heading">${m.name}</h4>
						<p class="card-desc">${m.description}</p>
						<a href="order" class="card-link">Order</a>
					</div>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${empty meals}">
			<p class="mealDisclaimer pFont text-align-center">No Meals are
				available</p>
		</c:if>



	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>