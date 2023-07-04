package com.MoW.DEASA.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meals")
public class Meal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mealId;
	
	@Column(nullable = false)
	private String mealName;
	
	@Column(nullable = false)
	private String mealDescription;
	
	@Column(nullable = false)
	private String mealStatus;
	
	@OneToMany(mappedBy = "meal")
    private List<Order> mealOrdered;

	public Meal() {
	}

	public Meal(Long mealId, String mealName, String mealDescription, String mealStatus) {
		this.mealId = mealId;
		this.mealName = mealName;
		this.mealDescription = mealDescription;
		this.mealStatus = mealStatus;
	}

	public Long getMealId() {
		return mealId;
	}

	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealDescription() {
		return mealDescription;
	}

	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}

	public String getMealStatus() {
		return mealStatus;
	}

	public void setMealStatus(String mealStatus) {
		this.mealStatus = mealStatus;
	}

	public List<Order> getMealOrdered() {
		return mealOrdered;
	}

	public void setMealOrdered(List<Order> mealOrdered) {
		this.mealOrdered = mealOrdered;
	}

}
