package com.project.assetmanageapp.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.assetmanageapp.constant.Status;

@Entity
public class Asset {

	/**
	 * entity asset variable
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private Date purchaseDate;
	
	private String conditionNote;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Category category;
	
	/**
	 * get and set enum string
	 *  to status
	 *  
	 *  getter and setters
	 */
	@Enumerated(EnumType.STRING)
	private Status status = Status.AVAILABLE;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getConditionNote() {
		return conditionNote;
	}

	public void setConditionNote(String conditionNote) {
		this.conditionNote = conditionNote;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	
	
	
}
