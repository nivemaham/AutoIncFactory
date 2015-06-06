package com.autoinc.businessControler;

import java.util.List;

import com.autoinc.bdo.AvailabilityResponse;
import com.autoinc.bdo.Product;
import com.autoinc.bdo.ProductDetails;
import com.autoinc.bdo.User;
import com.autoinc.dao.AddressDAO;
import com.autoinc.dao.CustomerDAO;

public interface AutoIncFactoryControler {
	
	List<Product> showProducts();
	
	ProductDetails viewProductDetails(int productId);
	
	AvailabilityResponse checkProductAvailablity(int productId, String deliveryLocation);
	
	boolean registerUser(User user);
	
	CustomerDAO registerCustomer(int userId,String name,int contactNo,String city,String country,String zipcode,String addLine1,String addLine2);

	AddressDAO saveAddress(String city,String country,String zipcode,String addLine1,String addLine2);
	
	List<String> showTransportationTypes();

}
