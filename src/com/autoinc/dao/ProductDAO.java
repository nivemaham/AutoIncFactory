package com.autoinc.dao;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.autoinc.bdo.Product;

@Entity
@Table(name = "product")
public class ProductDAO {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer productId;
	
	@Column(name = "modelnumber")
	private String modelnumber;
	
	@Column(name = "imageurl")
	private String imageurl;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "color")
	private String color;
	
	public ProductDAO() {
	}
	
	public ProductDAO(Product product)
	{
		this.productId = product.getProductId();
		this.modelnumber = product.getModelnumber();
		this.imageurl = product.getImageurl();
		this.manufacturer = product.getManufacturer();
		this.brand = product.getBrand();
		this.price = product.getPrice();
		this.color = product.getColor();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getModelnumber() {
		return modelnumber;
	}

	public void setModelnumber(String modelnumber) {
		this.modelnumber = modelnumber;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
