package com.MoW.DEASA.Entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String contact;

	private String currency;

	private double amount;

	private String accDetails;

	private Long donId;

	@CreatedDate
	private String date;

	@PrePersist
	private void onCreate() {
		DateFormat dateOnly = new SimpleDateFormat("EEEEE dd MMMMM yyyy");

		date = dateOnly.format(new Date());
	}

	public Donation() {
		super();
	}

	public Donation(Long id, String name, String contact, String currency, double amount, String accDetails, Long donId,
			String date) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.currency = currency;
		this.amount = amount;
		this.accDetails = accDetails;
		this.donId = donId;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccDetails() {
		return accDetails;
	}

	public void setAccDetails(String accDetails) {
		this.accDetails = accDetails;
	}

	public Long getDonId() {
		return donId;
	}

	public void setDonId(Long donId) {
		this.donId = donId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", name=" + name + ", contact=" + contact + ", currency=" + currency + ", amount="
				+ amount + ", accDetails=" + accDetails + ", donId=" + donId + ", date=" + date + "]";
	}

}
