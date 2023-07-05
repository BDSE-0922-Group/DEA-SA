<jsp:include page="../header.jsp">
	<jsp:param value="Login" name="HTMLtitle" />
</jsp:include>

<div class="custom-shape-divider-top-1686716923">
	<svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg"
		viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path
			d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z"
			class="shape-fill"></path>
        </svg>
</div>

<main class="bg1 align-center justify-center">

	<div class="align-center error-popup">
		<span class="material-icons">${error_message}</span>
		<p class="pFont error-text"></p>
		<button class="btnAnimation icon material-icons"
			onclick="closeFormError()">close</button>
	</div>

	<a href="dashboard"
		class="align-center login-popup btnAnimation text-deco-none text-align-center">
		<span class="material-icons">login</span>
		<p class="pFont login-text">${success_msg}</p>
	</a>

	<section class="align-center flex-col form-card">
		<h3 class="form-heading">Login</h3>

		<c:url var="post_url" value="/login"></c:url>

		<form class="align-center flex-col form" action="${post_url}"
			method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="input-group">
				<input required="true" type="text" name="username" id="userName"
					autocomplete="off" class="input" /> <label class="user-label">Username</label>
			</div>
			<div class="input-group">
				<input required="true" type="password" name="password" id="password"
					autocomplete="off" class="input" /> <label class="user-label">Password</label>
			</div>
			<input type="submit" class="submit-btn btnAnimation" value="Submit"></input>
		</form>
		<hr class="formDivider">
		<a href="register" class="altFormLink pFont text-deco-none">Don't
			have an account?</a>
	</section>

</main>

<jsp:include page="../footer.jsp"></jsp:include>