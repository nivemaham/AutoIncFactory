package com.autoinc.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "addline1")
	private String addLine1;
	
	@Column(name = "addline2")
	private String addLine2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;

	public AddressDAO() {
	}
	
	
	public AddressDAO(int id, String addLine1, String addLine2, String city,
			String country, String zipcode) {
		this.id = id;
		this.addLine1 = addLine1;
		this.addLine2 = addLine2;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	private String zipcode;
}
