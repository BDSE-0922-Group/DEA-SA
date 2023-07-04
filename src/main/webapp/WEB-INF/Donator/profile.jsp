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
			<li><label>Gender:</label>${gender}</li>
			<li><label>Username:</label>${uname}</li>
			<li><label>Address:</label>${address}</li>
			<li><label>Mobile No.:</label>${mobile}</li>
		</ul>

		<button id="edit-profile" class="btnAnimation material-icons">edit</button>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>