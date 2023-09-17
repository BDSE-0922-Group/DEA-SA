package com.MoW.DEASA.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.Entity.Orders;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Repo.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	public String save(Orders orders) {
		orderRepo.save(orders);
		
		return "Order has been placed";
	}
	
	public Orders getOrderById(Long id) {
		return orderRepo.getById(id);
	}
	
	public List<Orders> getAllOrders() {
		return orderRepo.findAll();
	}
	
	public List<Orders> getUserOrders(User user) {
		return orderRepo.findByUser(user);
	}
	
}
