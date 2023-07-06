package com.MoW.DEASA.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.Entity.Orders;
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
	
	public List<Orders> getAllOrders() {
		return orderRepo.findAll();
	}
	
	public List<Orders> getSPecificOrders(Long id) {
		return orderRepo.findByRecipientId(id);
	}
	
}
