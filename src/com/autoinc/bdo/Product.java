package com.autoinc.bdo;

import com.autoinc.dao.ProductDAO;

public class Product {

	private Integer productId;
	private String modelnumber;
	private String imageurl;
	private String manufacturer;
	private String brand;
	private Integer price;
	private String color;

	public Product(ProductDAO prodDao) {
		this.productId = prodDao.getProductId();
		this.modelnumber = prodDao.getModelnumber();
		this.imageurl = prodDao.getImageurl();
		this.manufacturer = prodDao.getManufacturer();
		this.brand = prodDao.getBrand();
		this.price = prodDao.getPrice();
		this.color = prodDao.getColor();
	}

	public Product() {
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
