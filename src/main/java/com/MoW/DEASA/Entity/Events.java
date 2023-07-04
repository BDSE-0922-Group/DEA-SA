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
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ev_id;

	private String ev_name;

	private String ev_desc;
	
	private String ev_venue;
	
	@CreatedDate
	private String ev_date;
	
	@PrePersist
	private void onCreate() {
		DateFormat dateOnly = new SimpleDateFormat("EEEEE dd MMMMM yyyy");

		ev_date = dateOnly.format(new Date());
	}

	public Long getEv_id() {
		return ev_id;
	}

	public void setEv_id(Long ev_id) {
		this.ev_id = ev_id;
	}

	public String getEv_name() {
		return ev_name;
	}

	public void setEv_name(String ev_name) {
		this.ev_name = ev_name;
	}

	public String getEv_desc() {
		return ev_desc;
	}

	public void setEv_desc(String ev_desc) {
		this.ev_desc = ev_desc;
	}

	public String getEv_venue() {
		return ev_venue;
	}

	public void setEv_venue(String ev_venue) {
		this.ev_venue = ev_venue;
	}

	public String getEv_date() {
		return ev_date;
	}

	public void setEv_date(String ev_date) {
		this.ev_date = ev_date;
	}

	@Override
	public String toString() {
		return "Events [ev_id=" + ev_id + ", ev_name=" + ev_name + ", ev_desc=" + ev_desc + ", ev_venue=" + ev_venue
				+ ", ev_date=" + ev_date + "]";
	}
	
	
}
