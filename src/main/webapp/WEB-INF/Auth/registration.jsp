<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Registration" name="HTMLtitle" />
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
			<span class="material-icons">error</span>
			<p id="error-text" class="pFont error-text"></p>
			<button class="btnAnimation icon material-icons"
				onclick="closeFormError()">close</button>
		</div>

		<section class="align-center flex-col form-card">
			<h3 class="form-heading">Sign up</h3>
			<sf:form action="register_user" method="post" id="registration"
				class="align-center flex-col form"
				onsubmit="validateRegistration(event)" modelAttribute="user">
				<div class="input-group">
					<sf:input required="true" type="text" name="name" path="name"
						autocomplete="off" id="fullname" class="input"
						onkeyup="validateFullname()" />
					<label class="user-label">Name</label>
				</div>
				<div class="input-group">
					<sf:input required="required" type="text" name="userName"
						path="userName" autocomplete="off" id="username" class="input"
						onkeyup="validateUsername()" />
					<label class="user-label">Username</label>
				</div>
				<div class="input-group">
					<sf:input required="true" type="text" name="email" path="email"
						autocomplete="off" id="email" class="input"
						onkeyup="validateEmail()" />
					<label class="user-label">Email</label>
				</div>
				<div class="input-group">
					<sf:input required="required" type="password" name="password"
						path="password" autocomplete="off" id="password" class="input"
						onkeyup="validatePassword()" />
					<label class="user-label">Password</label>
				</div>
				<div class="input-group">
					<label class="select-label">User Type</label> <select id="role"
						class="input-select" name="role">
						<option value="" selected disabled hidden>Choose here</option>
						<c:forEach items="${role}" var="role">
							<option value="${role.name}">${role.name}</option>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="submit-btn">Submit</button>
			</sf:form>
			<hr class="formDivider">
			<a href="login" class="altFormLink pFont text-deco-none">Already
				have an account?</a>
		</section>

	</main>

	<jsp:include page="../footer.jsp"></jsp:include>