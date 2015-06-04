package com.autoinc.bdo;

import com.autoinc.dao.ProductDetailsDAO;


public class ProductDetails {

	private Product product;

	private String engine;

	private String type;

	private String bodyStyle;

	private int mileage;
	
	public ProductDetails() {
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public ProductDetails(Product product, String engine, String type,
			String bodyStyle, int mileage) {
		
		this.product = product;
		this.engine = engine;
		this.type = type;
		this.bodyStyle = bodyStyle;
		this.mileage = mileage;
	}

	public ProductDetails(ProductDetailsDAO productDetails) {
		this.product = new Product(productDetails.getProduct());
		this.engine = productDetails.getEngine();
		this.type = productDetails.getType();
		this.bodyStyle = productDetails.getBodyStyle();
		this.mileage= productDetails.getMileage();
	}
	
	

}
