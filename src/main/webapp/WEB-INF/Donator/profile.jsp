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
	
	<div class="align-center success-popup">
		<span class="material-icons">done</span>
		<p id="error-text" class="pFont success-text">Success here</p>
		<button class="btnAnimation icon material-icons"
			onclick="closeSuccess()">close</button>
	</div>
	
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

		<button id="editProfile" class="btnAnimation material-icons">edit</button>
	</div>

	<dialog id="editProfileModal" class="modal" >
	
	<div class="align-center error-popup">
		<span class="material-icons">error</span>
		<p id="error-text" class="pFont error-text"></p>
		<button class="btnAnimation icon material-icons"
			onclick="closeFormError()">close</button>
	</div>
	<h3 class="modal-heading">Edit Profile</h3>
	<form id="editProfileForm" class="align-center flex-col form" onsubmit="validateEditProfile(event)">
		<div class="input-group">
			<input required="true" type="text" name="gender" autocomplete="off"
				id="fullname" class="input" onkeyup="validateFullname()"> <label class="user-label">Name</label>
		</div>
		<div class="input-group">
				<label class="select-label">Gender</label> <select id="gender"
					class="input-select" name="gender">
					<option value="" selected disabled hidden>Choose here</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="prefers not to say">Prefers not to say</option>
				</select>
			</div>
		<div class="input-group">
			<input required="true" type="text" name="gender" autocomplete="off"
				class="input" /> <label class="user-label">Address</label>
		</div>
		<div class="input-group">
			<input required="true" type="text" name="mobile" autocomplete="off"
				id="mobile" class="input" /> <label class="user-label">Mobile No.</label>
				
		</div>
		
		<button class="submit-btn btnAnimation" style="background-color: var(--success);">Save</button>
	</form>
	<button id="closeEditProfile" class="material-icons modal-close">close</button>
	</dialog>

</main>

<jsp:include page="../footer.jsp"></jsp:include>