<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div id="orderManagement" class="align-center flex-col dashboard-panel" style="display: none;">
	<h3>Order Management Table</h3>
	<table id="orderManagementTable" class="hFont">
		<thead>
			<tr>
				<th>No.</th>
				<th>Order ID</th>
				<th>Customer Name</th>
				<th>Order Date</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders}" var="order" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${order.orderId}</td>
					<td>${order.customerName}</td>
					<td>${order.orderDate}</td>
					<td>${order.status}</td>
					<td>
						<a href="${pageContext.request.contextPath}/view-order/${order.orderId}" class="material-icons view">visibility</a>
						<a href="${pageContext.request.contextPath}/edit-order/${order.orderId}" class="material-icons edit">edit</a>
						<a href="${pageContext.request.contextPath}/delete-order/${order.orderId}" class="material-icons delete">delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	
<!-- TODO: edit order management view modal based on order entity -->
<div id="viewOrderModal" class="modal">
	<div class="modal-content">
		<h3>Order Details</h3>
		<p>Order ID: ${order.orderId}</p>
		<p>Customer Name: ${order.customerName}</p>
		<p>Order Date: ${order.orderDate}</p>
		<!-- Add more order details based on order entity -->
		<button onclick="closeModals()">Close</button>
	</div>
</div>
	
<!-- TODO: edit order management update/edit modal based on order entity -->
<div id="editOrderModal" class="modal">
	<div class="modal-content">
		<h3>Edit Order</h3>
		<sf:form id="editOrderForm" modelAttribute="order" action="edit-order/${order.orderId}" method="post">
			<label for="customerName">Customer Name:
				<sf:input path="customerName" id="customerName" value="${order.customerName}" required="true" />
			</label>
			<!-- Add more fields for editing order details -->
			<button type="submit">Save</button>
			<button onclick="closeModals()">Cancel</button>
		</sf:form>
	</div>
</div>
	
<!-- TODO: order management delete modal (created delete-order delete mapping in AdminController) -->
<div id="deleteOrderModal" class="modal">
	<div class="modal-content">
		<h3>Delete Order</h3>
		<p>Are you sure you want to delete the order with ID ${order.orderId}?</p>
		<sf:form id="deleteOrderForm" action="delete-order/${order.orderId}" method="post">
			<button type="submit">Delete</button>
			<button onclick="closeModals()">Cancel</button>
		</sf:form>
	</div>
</div>