<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h1 class="dashboard-heading hFont text-align-center">Volunteer Dashboard</h1>
	
		<nav class="align-center justify-start dashboard-nav hFont">
				<a href="post-events"><button>Add an Event</button></a>
			</nav>	
	<div class="align-center flex-col dashboard-panel">
		<h3>Table of Events</h3>
		<table id="userManagement">
			<thead class="hFont">
				<tr>
					<th>Event No.</th>
					<th>Event Name</th>
					<th>Event Description</th>
					<th>Event Venue</th>
					<th>Event Date</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<c:if test="${not empty events}">
					<c:forEach items="${events}" var="e" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${e.name}</td>
							<td>${e.description}</td>
							<td>${e.venue}</td>
							<td>${e.date}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty events}">
						<tr>
							<td colspan="6">No donation made yet</td>
						</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</main>
<jsp:include page="../footer.jsp"></jsp:include>