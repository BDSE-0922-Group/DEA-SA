<jsp:include page="../header.jsp">
	<jsp:param value="Home" name="HTMLtitle" />
</jsp:include>

<main class="bg3 align-center flex-col">
	<div id="profile-card" class="align-center flex-col pFont">
		<img src="https://placehold.co/300x300" alt="profile picture"
			width="300" height="300" />
		<h4>Anzel Ken Sakamoto</h4>
		<ul id="user-details" class="flex-col list-style-none">
			<li><label>Gender:</label>Male</li>
			<li><label>Username:</label>anzel_sakamoto</li>
			<li><label>Address:</label>404 Address st. Sample City</li>
			<li><label>Mobile No.:</label>09062820823</li>
		</ul>

		<button id="edit-profile" class="btnAnimation material-icons">edit</button>
	</div>
</main>

<jsp:include page="../footer.jsp"></jsp:include>