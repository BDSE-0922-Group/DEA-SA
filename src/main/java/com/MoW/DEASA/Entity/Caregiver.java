package com.MoW.DEASA.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Caregiver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="user_id")
	private Long userId;
	
	private Long orderId;
	
	
	//	CONSTRUCTORS
	public Caregiver() {
		
	}
	
	public Caregiver(Long id, Long userId, Long orderId) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderId = orderId;
	}
	
	
	//	SET-GET

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	private Long getUserId() {
		return userId;
	}
	
	private void setUserId(Long userId) {
		this.userId = userId;
	}
	
	private Long getOrderId() {
		return orderId;
	}
	
	private void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		return "Caregiver [id=" + id + ", userid=" + userId + ", orderid=" + orderId
				+ " , getUserId=" + getUserId() + ", getOrderId" + getOrderId() + "]";
	}
	
}