package com.MoW.DEASA.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.Entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	List<Orders> findByRecipientId(Long id);
	
}