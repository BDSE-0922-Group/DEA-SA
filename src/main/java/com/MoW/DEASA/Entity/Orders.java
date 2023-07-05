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
	private Long ord_id;

	private String ord_meal;

	private String ord_desc;
	
	private String ord_status;
	
	private String ord_by;
	
	@CreatedDate
	private String ord_date;
	
	@PrePersist
	private void onCreate() {
		DateFormat dateOnly = new SimpleDateFormat("EEEEE dd MMMMM yyyy");

		ord_date = dateOnly.format(new Date());
	}

	public Long getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(Long ord_id) {
		this.ord_id = ord_id;
	}

	public String getOrd_meal() {
		return ord_meal;
	}

	public void setOrd_meal(String ord_meal) {
		this.ord_meal = ord_meal;
	}

	public String getOrd_desc() {
		return ord_desc;
	}

	public void setOrd_desc(String ord_desc) {
		this.ord_desc = ord_desc;
	}

	public String getOrd_status() {
		return ord_status;
	}

	public void setOrd_status(String ord_status) {
		this.ord_status = ord_status;
	}

	public String getOrd_by() {
		return ord_by;
	}

	public void setOrd_by(String ord_by) {
		this.ord_by = ord_by;
	}

	public String getOrd_date() {
		return ord_date;
	}

	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}

	@Override
	public String toString() {
		return "Order [ord_id=" + ord_id + ", ord_meal=" + ord_meal + ", ord_desc=" + ord_desc + ", ord_status="
				+ ord_status + ", ord_by=" + ord_by + ", ord_date=" + ord_date + "]";
	}

	public Orders(Long ord_id, String ord_meal, String ord_desc, String ord_status, String ord_by, String ord_date) {
		super();
		this.ord_id = ord_id;
		this.ord_meal = ord_meal;
		this.ord_desc = ord_desc;
		this.ord_status = ord_status;
		this.ord_by = ord_by;
		this.ord_date = ord_date;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}