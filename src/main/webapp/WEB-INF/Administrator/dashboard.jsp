<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../header.jsp">
	<jsp:param value="Member" name="HTMLtitle" />
</jsp:include>

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Admin Dashboard</h2>
	
	<nav class="align-center justify-start dashboard-nav hFont">
		<a href="dashboard"><button>User Management</button></a>
	</nav>
	
	<div class="align-center flex-col dashboard-panel">
		<h3>User Management Table</h3>
		<table id="userManagement">
			<thead class="hFont">
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Username</th>
					<th>Email</th>
					<th>Role</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody class="pFont">

				<c:forEach items="${users }" var="u" varStatus="item">

					<tr>
						<td>${item.count }</td>
						<td>${u.name }</td>
						<td>${u.userName }</td>
						<td>${u.email }</td>

						<td><sf:form class="role-form"
								action="/reassign_user?username=${u.userName }" method="post"
								modelAttribute="user">
								<c:forEach items="${u.roles}" var="r">
									<input value="${r.name}" name="roleString" style="width: 100px;"/>
								</c:forEach>
								<button class="material-icons crud-actions edit" type="submit">edit</button>
							</sf:form></td>
						<td><a href="" class="material-icons edit">edit</a> <a
							href="" class="material-icons delete">delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</main>



<jsp:include page="../footer.jsp"></jsp:include>