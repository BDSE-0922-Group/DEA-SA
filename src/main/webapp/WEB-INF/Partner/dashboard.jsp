<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Partner Dashboard</h2>
	<nav class="align-center justify-start dashboard-nav hFont">
		<a href="post-meal"><button>Add a Meal</button></a>
	</nav>

	<div class="align-center flex-col dashboard-panel">
		<h3>Table of Events</h3>
		<table id="userManagement">
			<thead class="hFont">
				<tr>
					<th>Meal ID</th>
					<th>Meal Name</th>
					<th>Meal Photo</th>
					<th>Meal Description</th>
					<th>Availability</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<c:if test="${not empty meals}">
					<c:forEach items="${meals}" var="m" varStatus="status">
						<tr>
							<td>M-${m.id}</td>
							<td>${m.name}</td>
							<td><img src="${m.photos}"/></td>
							<td>${m.description}</td>
							<td>${m.availability}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty meals}">
						<tr>
							<td colspan="6">No donation made yet</td>
						</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	
</main>

<jsp:include page="../footer.jsp"></jsp:include>