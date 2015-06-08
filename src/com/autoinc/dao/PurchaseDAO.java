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
@Table(name = "purchase")
public class PurchaseDAO implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1745573660709028792L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToOne
    @JoinColumn(name = "customerid")
	private CustomerDAO customer;
	
	@OneToOne
    @JoinColumn(name = "productid")
	private ProductDAO product;
	
	@OneToOne
    @JoinColumn(name = "supplier")
	private SupplyLogisticsDAO supplier;
	
	@Column(name = "orderstatus")
	private String orderStatus;
	
	@Column(name = "totalcost")
	private double totalCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerDAO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDAO customer) {
		this.customer = customer;
	}

	public ProductDAO getProduct() {
		return product;
	}

	public void setProduct(ProductDAO product) {
		this.product = product;
	}

	public SupplyLogisticsDAO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplyLogisticsDAO supplier) {
		this.supplier = supplier;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
}
