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
@Table(name = "deliveryoffers")
public class DeliveryOffersDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id",nullable=false)
	private int id;
	
	@OneToOne
    @JoinColumn(name = "supplierid")
	private SupplyLogisticsDAO supplier;
	
	@Column(name = "servicelevel")
	private String serviceLevel;
	  
	@Column(name = "costperunit")
	private float costPerUnit;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public SupplyLogisticsDAO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplyLogisticsDAO supplier) {
		this.supplier = supplier;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public float getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(float costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	
	
	

}
