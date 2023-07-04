package com.MoW.DEASA.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MoW.DEASA.entity.Order;
import com.MoW.DEASA.enums.OrderStatus;
import com.MoW.DEASA.service.OrderService;

@RestController
public class PartnerController {
	
	private final OrderService orderService;
	
	public PartnerController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PutMapping("/order-{orderId}/status")
    public ResponseEntity<String> updateOrderStatusByPartner(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        Order updatedOrder = orderService.updateOrderStatusByPartner(orderId, status);
        if (updatedOrder == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Order status updated successfully");
    }

}
