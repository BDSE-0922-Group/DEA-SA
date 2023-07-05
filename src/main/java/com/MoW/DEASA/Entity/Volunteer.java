package com.MoW.DEASA.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Volunteer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vol_id;

	private String vol_name;

	private String ord_desc;
	
	private String ord_status;
	
	private String ord_by;
	
}
