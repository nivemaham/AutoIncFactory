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
@Table(name = "customer")
public class CustomerDAO implements Serializable {
	


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		@Column(name = "id")
		private int id;
		
		@OneToOne
	    @JoinColumn(name = "userid",nullable=false)
		private UserDAO user;
		
		@Column(name = "name")
		private String name;
		  
		@OneToOne
	    @JoinColumn(name = "addressid",nullable=false)
		private AddressDAO address;
		

		@Column(name = "contactnumber")
		private int contactNumber;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		
		public UserDAO getUser() {
			return user;
		}

		public void setUser(UserDAO user) {
			this.user = user;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		

		public int getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(int contactNumber) {
			this.contactNumber = contactNumber;
		}
		
		public AddressDAO getAddress() {
			return address;
		}

		public void setAddress(AddressDAO address) {
			this.address = address;
		}
		

}
