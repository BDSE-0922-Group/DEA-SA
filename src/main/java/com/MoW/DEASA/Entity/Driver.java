package com.MoW.DEASA.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;
	
	@Column(name = "ord_id")
	private Long orderId;

//	
//	@CreatedDate
//	private LocalDate orderDate;
//	
//	private LocalDate deliveryDate;
	
	
	private Long getDriverId() {
		return id;
	}
	
	
	public Long getUserId() {
	    return userId;
	}
	
	
	public void setUserId(Long userId) {
	    this.userId = userId;
	}
	  
//
//	  public void setOrderDate() {
//	      this.orderDate = LocalDate.now();
//	  }
//	  
//	  public LocalDate getOrderDate() {
//	      return orderDate;
//	  }
//
//
//	  public LocalDate getDeliveryDate() {
//	      return getDeliveryDate;
//	  }
//
//	  public void setEmailVerifiedDate() {
//	      this.getDeliveryDate = LocalDate.now();
//	  }
	
}