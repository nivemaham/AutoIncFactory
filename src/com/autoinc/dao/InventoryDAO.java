package com.autoinc.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class InventoryDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name = "id",nullable=false)
	private int id;
	
	  
	@OneToOne
	@JoinColumn(name = "warehouseId",nullable=false)
	private WarehouseDAO warehouse;
	
	@Column(name = "modelnumber",nullable=false)
	private String modelNumber;
	
	@Column(name = "color",nullable=false)
	private String color;
	  
	@Column(name = "quantity",nullable=false)
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public WarehouseDAO getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseDAO warehouse) {
		this.warehouse = warehouse;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
