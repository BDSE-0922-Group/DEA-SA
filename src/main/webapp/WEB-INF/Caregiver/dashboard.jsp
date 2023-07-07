<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp">
	<jsp:param value="Member" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Rider Dashboard</h2>
	<div class="align-center flex-col dashboard-panel">	
		<h3>Meals Available for Delivery</h3>
		<table class="dashboard-table">
			<thead class="hFont">
				<tr>
					<th>Order No.</th>
					<th>Meal Name</th>
					<th>Ordered By</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<tr>
					<td>1</td>
					<td>Spaghetti</td>
					<td>John Doe</td>
					<td>
						<!-- TODO: place in-line styles into css. -->
						<button class="material-icons view" style="width:50px;">visibility</button>
						<button class="material-icons delete">delete</button>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Chicken</td>
					<td>John Doe</td>
					<td>
						<button class="material-icons view" style="width:50px;">visibility</button>
						<button class="material-icons delete"">delete</button>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Soup</td>
					<td>John Doe</td>
					<td>
						<button class="material-icons view" style="width:50px;">visibility</button>
						<button class="material-icons delete">delete</button>
					</td>
				</tr>
				<tr>
				</tr>
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