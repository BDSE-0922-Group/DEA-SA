package com.MoW.DEASA.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MoW.DEASA.entity.Order;
import com.MoW.DEASA.service.OrderService;

@RestController
public class DriverController {
	
	// TODO
	// create methods where the driver can take up an order
	// to be tested in the app (needs to have the driver logged in)
	
	private final OrderService orderService;
	
	public DriverController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PutMapping("/order-{orderId}/driver")
    public ResponseEntity<String> assignDriverToOrder(@PathVariable Long orderId, @RequestParam Long driverId) {
        Order updatedOrder = orderService.assignDriverToOrder(orderId, driverId);
        if (updatedOrder == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Driver assigned successfully");
    }

}
