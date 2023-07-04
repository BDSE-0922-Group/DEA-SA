package com.MoW.DEASA.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MoW.DEASA.Entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
