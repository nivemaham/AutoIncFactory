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
@Table(name = "transportationstatus")
public class TransportationStatusDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6535044495872771008L;

	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@OneToOne
    @JoinColumn(name = "orderId")
	private OrderDAO orderDAO;
	
	@Column(name = "shippingstatus")
	private int shippingStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public int getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(int shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
}
