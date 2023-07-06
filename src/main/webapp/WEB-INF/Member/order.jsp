<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Order" name="HTMLtitle" />
</jsp:include>

<main class="bg3 align-center justify-center">

	<div class="align-center error-popup">
		<span class="material-icons">error</span>
		<p id="error-text" class="pFont error-text"></p>
		<button class="btnAnimation icon material-icons"
			onclick="closeFormError()">close</button>
	</div>

	<section class="align-center flex-col form-card">
		<h3 class="form-heading">Order Meal</h3>
		<sf:form class="align-center flex-col form" action="place_order"
			method="post" modelAttribute="order" enctype="multipart/form-data">
			
			<sf:input required="true" type="hidden" name="status" autocomplete="off"
					path="status" class="input" value="ongoing"/>
			
			<div class="input-group">
				<label class="select-label">Meal to Order</label> <select id="meal"
					class="input-select" name="mealId">
					
					<option value="" selected disabled hidden>Choose here</option>
					
					<c:forEach items="${meals}" var="meals">
						<option value="${meals.id}">${meals.name}</option>
					</c:forEach>
					
				</select>
			</div>
			
			<div class="input-group">
				<sf:textarea rows="5" required="true" name="description"
					autocomplete="off" path="description" class="input input-textarea" />
				<label class="user-label">Requests (optional)</label>
			</div>
			
			<button type="submit" class="submit-btn">Add Meal</button>
		</sf:form>
	
	</section>

</main>

<jsp:include page="../footer.jsp"></jsp:include>