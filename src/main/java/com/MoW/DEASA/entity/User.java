package com.MoW.DEASA.entity;

import java.util.List;

import javax.persistence.*;

import com.MoW.DEASA.enums.UserRole;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;
    
    @OneToMany(mappedBy = "customer")
    private List<Order> ordersAsCustomer;

    @OneToMany(mappedBy = "partner")
    private List<Order> ordersAsPartner;

    @OneToMany(mappedBy = "driver")
    private List<Order> ordersAsDriver;

    public User() {
    }

    public User(String userName, String userEmail, String userPassword, UserRole userRole) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<Order> getOrdersAsCustomer() {
		return ordersAsCustomer;
	}

	public void setOrdersAsCustomer(List<Order> ordersAsCustomer) {
		this.ordersAsCustomer = ordersAsCustomer;
	}

	public List<Order> getOrdersAsPartner() {
		return ordersAsPartner;
	}

	public void setOrdersAsPartner(List<Order> ordersAsPartner) {
		this.ordersAsPartner = ordersAsPartner;
	}

	public List<Order> getOrdersAsDriver() {
		return ordersAsDriver;
	}

	public void setOrdersAsDriver(List<Order> ordersAsDriver) {
		this.ordersAsDriver = ordersAsDriver;
	}

}

