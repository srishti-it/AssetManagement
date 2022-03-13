package com.project.assetmanageapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	/**
	 * variables
	 *  getter and setters for category class
	 *  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy="category")
	@JsonIgnore
	private List<Asset> asset; 
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public List<Asset> getAsset() {
		return asset;
	}
	public void setAsset(List<Asset> asset) {
		this.asset = asset;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
