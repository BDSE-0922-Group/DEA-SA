package com.MoW.DEASA.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	@Column(nullable = true, length = 64)
	private String photos;

	@Column(nullable = true, length = 64)
	private String photoImagePath;

	
//	CONSTRUCTORS
	public Meal(Long id, String name, String description, String photos, String photoImagePath) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photos = photos;
		this.photoImagePath = photoImagePath;
	}
	
	
//	GETTER SETTERS
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	public String getPhotoImagePath() {
		return photoImagePath;
	}
	public void setPhotoImagePath(String photoImagePath) {
		this.photoImagePath = photoImagePath;
	}

	
//	TO STRING
	@Override
	public String toString() {
		return "Meal [id=" + id + ", name=" + name + ", description=" + description + ", photos=" + photos + ", photoImagePath="
				+ photoImagePath + ", getId()=" + getId() + ", getName()=" + getName() + ", getDescription()=" + getDescription()
				+ ", getPhotos()=" + getPhotos() + ", getPhotoImagePath()=" + getPhotoImagePath() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}