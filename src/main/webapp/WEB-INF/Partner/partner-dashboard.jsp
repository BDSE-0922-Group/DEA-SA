<<<<<<< Updated upstream:src/main/webapp/WEB-INF/Partner/partner-dashboard.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../header.jsp">
	<jsp:param value="Admin" name="HTMLtitle" />
</jsp:include>

<!-- TODO: please help update css for this :,)) -->

<main class="bg2 align-center flex-col">
	<h2 class="dashboard-heading hFont">Admin Dashboard</h2>
	
	<nav class="align-center justify-start dashboard-nav hFont">
		<button id="userManagementButton" onclick="showDiv('userManagement')">User Management</button>
		<button id="orderManagementButton" onclick="showDiv('orderManagement')">Order Management</button>
	</nav>
	
	<!-- user management dashboard -->
	<jsp:include page="user-management.jsp" />
	
	<!-- TODO: no entity, repo, service, and controller yet -->
	<!-- order management dashboard -->
	<jsp:include page="order-management.jsp" />
	
	<script>
		function showDiv(divId) {
	        const userManagementDiv = document.getElementById('userManagement');
	        const orderManagementDiv = document.getElementById('orderManagement');
	        const userManagementButton = document.getElementById('userManagementButton');
	        const orderManagementButton = document.getElementById('orderManagementButton');
	
	        userManagementDiv.style.display = divId === 'userManagement' ? 'block' : 'none';
	        orderManagementDiv.style.display = divId === 'orderManagement' ? 'block' : 'none';
	
	        userManagementButton.classList.toggle('active', divId === 'userManagement');
	        orderManagementButton.classList.toggle('active', divId === 'orderManagement');
	    }
	
	    function closeModals() {
	        const modals = document.getElementsByClassName('modal');
	        for (let i = 0; i < modals.length; i++) {
	            modals[i].style.display = 'none';
	        }
		}
	</script>

</main>

<jsp:include page="../footer.jsp"></jsp:include>
>>>>>>> Stashed changes:src/main/webapp/WEB-INF/Administrator/dashboard.jsp
