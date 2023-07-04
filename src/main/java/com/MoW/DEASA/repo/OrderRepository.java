package com.MoW.DEASA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
