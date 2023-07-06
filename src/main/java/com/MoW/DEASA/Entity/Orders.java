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
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long mealId;

	private String description;
	
	private String status;
	
	private Long recipientId;
	
	@CreatedDate
	private String date;
	
	@PrePersist
	private void onCreate() {
		DateFormat dateOnly = new SimpleDateFormat("EEEEE dd MMMMM yyyy");

		date = dateOnly.format(new Date());
	}

	
//	CONSTRUCTOR
	public Orders() {
	}
	
	public Orders(Long id, Long mealId, String description, String status, Long recipientId, String date) {
		super();
		this.id = id;
		this.mealId = mealId;
		this.description = description;
		this.status = status;
		this.recipientId = recipientId;
		this.date = date;
	}

	
//	GETTER SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getMealId() {
		return mealId;
	}
	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

//	TO STRING
	@Override
	public String toString() {
		return "Orders [id=" + id + ", mealId=" + mealId + ", description=" + description + ", status=" + status
				+ ", recipientId=" + recipientId + ", date=" + date + ", getId()=" + getId() + ", getMealId()="
				+ getMealId() + ", getDescription()=" + getDescription() + ", getStatus()=" + getStatus()
				+ ", getRecipientId()=" + getRecipientId() + ", getDate()=" + getDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}