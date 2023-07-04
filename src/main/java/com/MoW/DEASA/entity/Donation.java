package com.MoW.DEASA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donations")
public class Donation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donationId;
	
	@Column(nullable = false)
	private String donorName;
	
	@Column(nullable = false)
	private Long donationAmount;
	
	@Column(nullable = false)
	private String donationMethod;
	
	// TODO
	// not final. wait for paypal/payment method API code

}
