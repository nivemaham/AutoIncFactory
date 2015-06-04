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
@Table(name = "warehouse")
public class WarehouseDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "warehouseid",nullable=false)
	private int id;
	
	@OneToOne
    @JoinColumn(name = "locationid",nullable=false)
	private AddressDAO address;
	
	@Column(name = "capacity",nullable=false)
	private int capacity;
	
	@Column(name = "serviceurl",nullable=false)
	private String serviceUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		public AddressDAO getAddress() {
		return address;
	}

	public void setAddress(AddressDAO address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	
}
