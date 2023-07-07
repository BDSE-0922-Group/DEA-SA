<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp">
	<jsp:param value="Caregiver" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Rider Dashboard</h2>
	<div class="align-center flex-col dashboard-panel">	
		<h3>Meals Available for Delivery</h3>
		<table class="dashboard-table">
			<thead class="hFont">
				<tr>
					<th>Order ID</th>
					<th>Meal Name</th>
					<th>Ordered By</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<c:forEach items="${orderDetails}" var="orderDetails">
					<tr>
						<td><option value="${orderDetails[0]}" name="orderId">${orderDetails[0]}</option></td>
						<td><option value="${orderDetails[1]}" name="mealName">${orderDetails[1]}</option></td>
						<td><option value="${orderDetails[2]}" name="recipientName">${orderDetails[2]}</option></td>
						<td><option value="${orderDetails[3]}" name="orderStatus">${orderDetails[3]}</option></td>
						<%-- <td><option value="${meals.user_id}">${meals.user_id}</option></td> --%>
						<!-- <td>John Doe</td> -->
						<td>
							<button class="material-icons view" style="width:50px;">visibility</button>
							<button class="material-icons delete">delete</button>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
				<tbody class="pFont">	
				<c:if test="${not empty order}">
					<c:forEach items="${order}" var="o">
						<tr>
							<td>${o.getName()}</td>
							<td>${o.getAccDetails()}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty order}">
					<tr>
						<td colspan="6">No orders yet</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>

