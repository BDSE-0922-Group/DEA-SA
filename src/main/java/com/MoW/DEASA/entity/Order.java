package com.MoW.DEASA.entity;

import com.MoW.DEASA.entity.User;
import com.MoW.DEASA.enums.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	
	// TODO
	// hot meal/cold meal based on distance? to be set on the controller as a customer orders? use enum again?
	// to test to see if there is a need for dto/payload

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private User partner;
    
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne(optional = true)
    @JoinColumn(name = "driver_id")
    private User driver;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

	public Order() {
	}

	public Order(Long orderId, User customer, User partner, Meal meal, User driver, OrderStatus status) {
		this.orderId = orderId;
		this.customer = customer;
		this.partner = partner;
		this.meal = meal;
		this.driver = driver;
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public User getPartner() {
		return partner;
	}

	public void setPartner(User partner) {
		this.partner = partner;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
