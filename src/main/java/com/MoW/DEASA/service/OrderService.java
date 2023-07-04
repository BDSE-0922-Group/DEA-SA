package com.MoW.DEASA.service;

import com.MoW.DEASA.entity.Order;
import com.MoW.DEASA.entity.User;
import com.MoW.DEASA.enums.OrderStatus;
import com.MoW.DEASA.repo.OrderRepository;
import com.MoW.DEASA.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order ID"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long orderId, Order updatedOrder) {
        Order order = getOrderById(orderId);
        order.setCustomer(updatedOrder.getCustomer());
        order.setPartner(updatedOrder.getPartner());
        order.setDriver(updatedOrder.getDriver());
        order.setStatus(updatedOrder.getStatus());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
    
    public Order updateOrderStatusByPartner(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElse(null);
        if (order == null) {
            return null; // Order not found
        }
        if (status == OrderStatus.IN_THE_KITCHEN || status == OrderStatus.ON_ROUTE) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null; // Invalid
    }
    
    public Order assignDriverToOrder(Long orderId, Long driverId) {
        Order order = orderRepository.findById(orderId)
                .orElse(null);
        User driver = userRepository.findById(driverId)
                .orElse(null);
        if (order == null || driver == null) {
            return null; // Order or driver not found
        }
        order.setDriver(driver);
        order.setStatus(OrderStatus.ON_ROUTE);
        return orderRepository.save(order);
    }
    
    public Order completeOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElse(null);
        if (order == null) {
            return null; // Order not found
        }
        order.setStatus(OrderStatus.COMPLETED);
        return orderRepository.save(order);
    }
}
