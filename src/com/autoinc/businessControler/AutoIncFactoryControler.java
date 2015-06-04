package com.autoinc.businessControler;

import java.util.List;

import com.autoinc.bdo.AvailabilityResponse;
import com.autoinc.bdo.Product;
import com.autoinc.bdo.ProductDetails;
import com.autoinc.bdo.User;

public interface AutoIncFactoryControler {
	
	List<Product> showProducts();
	
	ProductDetails viewProductDetails(int productId);
	
	AvailabilityResponse checkProductAvailablity(int productId, String deliveryLocation);
	
	boolean registerUser(User user);
	

}
