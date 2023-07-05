<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Profile" name="HTMLtitle" />
</jsp:include>

<main class="bg3 align-center flex-col">
	<c:forEach items="${user}" var="u">
		<c:set var="id" value="${u.id}"></c:set>
		<c:set var="name" value="${u.name}"></c:set>
		<c:set var="uname" value="${u.userName}"></c:set>
		<c:set var="email" value="${u.email}"></c:set>
		<c:set var="mobile" value="${u.mobile}"></c:set>
		<c:set var="address" value="${u.address}"></c:set>
		<c:set var="gender" value="${u.gender}"></c:set>
	</c:forEach>

	<div id="profile-card" class="align-center flex-col pFont">
		<img src="https://placehold.co/300x300" alt="profile picture"
			width="300" height="300" />
		<h4>${name}</h4>
		<ul id="user-details" class="flex-col list-style-none">
			<c:if test="${ (gender == null) }">
				<li><label>Gender:</label>Not specified</li>
			</c:if>
			<c:if test="${ (gender != null) }">
				<li><label>Gender:</label>${gender}</li>
			</c:if>
			<li><label>Username:</label>${uname}</li>
			<c:if test="${ (address == null) }">
				<li><label>Address:</label>Not specified</li>
			</c:if>
			<c:if test="${ (address != null) }">
				<li><label>Address:</label>${address}</li>
			</c:if>
			<c:if test="${ (mobile == null) }">
			<li><label>Mobile No.:</label>Not specified</li>
			</c:if>
			<c:if test="${ (mobile != null) }">
			<li><label>Mobile No.:</label>${mobile}</li>
			</c:if>
		</ul>

		<button id="edit-profile" class="btnAnimation material-icons">edit</button>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>