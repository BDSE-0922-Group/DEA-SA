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
						<td><p value="${orderDetails[0]}" name="orderId">${orderDetails[0]}</p></td>
						<td><p value="${orderDetails[1]}" name="mealName">${orderDetails[1]}</p></td>
						<td><p value="${orderDetails[2]}" name="recipientName">${orderDetails[2]}</p></td>
						<td><p value="${orderDetails[3]}" name="orderStatus">${orderDetails[3]}</p></td>
						<td>
							<form id="orderReceivedForm" class="align-center flex-col form">
								<button class="material-icons view btnAnimation" name="orderReceived" style="width:80px;">visibility</button>
							</form>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>

