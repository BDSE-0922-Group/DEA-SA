package com.MoW.DEASA.dto;

import com.MoW.DEASA.enums.OrderStatus;

public class NewOrder {
	private Long orderId;
    private Long customerId;
    private Long partnerId;
    private Long driverId;
    private OrderStatus status;
    
	public NewOrder() {
	}

	public NewOrder(Long orderId, Long customerId, Long partnerId, Long driverId, OrderStatus status) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.partnerId = partnerId;
		this.driverId = driverId;
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
