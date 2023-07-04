package com.MoW.DEASA.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MoW.DEASA.entity.Order;
import com.MoW.DEASA.service.OrderService;

@RestController
public class CustomerController {
	
	private final OrderService orderService;
	
	public CustomerController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/order")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
	
	@PutMapping("/order-{orderId}/complete")
    public ResponseEntity<String> completeOrder(@PathVariable Long orderId) {
        Order updatedOrder = orderService.completeOrder(orderId);
        if (updatedOrder == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Order status updated to completed");
    }

}
