<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
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
					<th>Action</th>
				</tr>
			</thead>
			<tbody class="pFont">
				<c:if test="${not empty events}">
					<c:forEach items="${events}" var="e" varStatus="status">
						<tr>
							<td>E-${e.id}</td>
							<td>${e.name}</td>
							<td>${e.description}</td>
							<td>${e.venue}</td>
							<td>${e.date}</td>
							<td>
							
							<!-- Button trigger modal -->
									<button type="button" class="btn btn-success"
										data-bs-toggle="modal"
										data-bs-target="#exampleModal${status.index}">
										<i class="fas fa-edit"></i>
									</button> <!-- Modal -->

									<div class="modal fade" id="exampleModal${status.index}"
										tabindex="-1" aria-labelledby="exampleModalLabel"
										aria-hidden="true" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Edit
														User</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">

													<!-- User Update Form -->
													<sf:form action="/edit?eid=${e.id}" method="post"
														class="was-validated" modelAttribute="events">
														<div class="">
															<label for="e.name" class="form-label">Event Name:</label> <input
																type="text" class="form-control"
																placeholder="Enter Event Name" name="name" value="${e.name}"
																required="true" />
															<div class="valid-feedback">Valid.</div>
															<div class="invalid-feedback">Please fill out this
																field.</div>
														</div>
														<div class="mb-3">
															<label for="e.desc" class="form-label">Event Description:</label>
															<input type="text" class="form-control" id="description"
																placeholder="Enter Event Description" name="description"
																value="${e.description}" required="true" />
															<div class="valid-feedback">Valid.</div>
															<div class="invalid-feedback">Please fill out this
																field.</div>
														</div>
														
														<div class="mb-3">
															<label for="e.venue" class="form-label">Event Venue:</label> <input
																type="text" class="form-control"
																placeholder="Enter Event Venue" name="venue" id="venue"
																value="${e.venue}" required="true" />
															<div class="valid-feedback">Valid.</div>
															<div class="invalid-feedback">Please fill out this
																field.</div>
														</div>
														<div class="mb-3">
															<label for="e.mobile">Event Date:</label> <input
																type="date" class="form-control" id="date"
																placeholder="Enter Event Date" name="date"
																value="${e.date}" required="true" />
															<div class="valid-feedback">Valid.</div>
															<div class="invalid-feedback">Please fill out this
																field.</div>
														</div>
														<button type="submit" class="btn btn-primary">Edit</button>
													</sf:form>
													<!-- User Update Form -->
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Close</button>

												</div>
											</div>
										</div>

									</div> <a type="button" class="btn btn-danger"
									href="/delete?eid=${e.id}"> <i class="far fa-trash-alt"></i>
								</a></td>
						</tr>
					</c:forEach>

				</c:if>
				<c:if test="${empty events}">
						<tr>
							<td colspan="6">No Events Yet</td>
						</tr>
				</c:if>
				
			</tbody>
		</table>
	</div>
</main>
<jsp:include page="../footer.jsp"></jsp:include>