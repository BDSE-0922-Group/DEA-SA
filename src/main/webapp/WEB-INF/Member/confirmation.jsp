<jsp:include page="../header.jsp">
	<jsp:param value="Order Confirmed" name="HTMLtitle" />
</jsp:include>

<jsp:include page="../headerDivider.jsp"></jsp:include>

<main class="bg1 align-center justify-center">

	<div class="align-center util-card flex-col">
		<img src="images/order-confirm.svg" alt="Confirmation" width="400"
			height="300" />
		<p class="hFont text-align-center">Order has been successfully placed</p>
		<a href="ongoing-orders" class="btnAnimation pFont text-deco-none">Click
			here to view your order</a>
	</div>

</main>

<jsp:include page="../footer.jsp"></jsp:include>
	