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
					<th>Actions</th>
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
							<td><!-- Button trigger modal -->
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
														Meal</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">

													<!-- User Update Form -->
													<sf:form action="/update?mid=${m.id}" method="post"
														class="was-validated" modelAttribute="meal">
														<div class="mb-3">
															<label for="e.name" class="form-label">Meal Name:</label> <input
																type="text" class="form-control"
																placeholder="Enter New Meal Name" name="name" value="${m.name}"
																required="true" />
															<div class="valid-feedback">Valid.</div>
															<div class="invalid-feedback">Please fill out this
																field.</div>
														</div>
														<div class="mb-3">
															<label for="e.desc" class="form-label">Meal Description:</label>
															<input type="text" class="form-control" id="description"
																placeholder="Enter New Meal Description" name="description"
																value="${m.description}" required="true" />
															<div class="valid-feedback">Valid.</div>
															<div class="invalid-feedback">Please fill out this
																field.</div>
														</div>
														
														<div class="mb-3">
															<label for="e.venue" class="form-label">Meal Availability:</label> 
																<select
																	class="input-select" name="availability" path="availability"> 
																	<option value="" selected disabled hidden>Choose here</option>
																	<option value="Available"  >Available</option>
																	<option value="Not Available" >Not Available</option>
																</select>
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
									href="/remove?mid=${m.id}"> <i class="far fa-trash-alt"></i>
								</a></td>
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
		<script>
            $(document).ready(() => {
            	
                $("#photo").change(function () {
                    const file = this.files[0];
                    if (file) {
                        let reader = new FileReader();
                        reader.onload = function (event) {
                            $("#imgPreview")
                              .attr("src", event.target.result);
                        };
                        reader.readAsDataURL(file);
                    }
                });
            });
       </script>
<jsp:include page="../footer.jsp"></jsp:include>