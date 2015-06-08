package com.autoinc.businessControler;

import java.util.List;

import com.autoinc.bdo.AvailabilityResponse;
import com.autoinc.bdo.Product;
import com.autoinc.bdo.ProductDetails;
import com.autoinc.bdo.User;
import com.autoinc.dao.AddressDAO;
import com.autoinc.dao.CustomerDAO;
import com.autoinc.dao.DeliveryOffersDAO;
import com.autoinc.dao.PurchaseDAO;

public interface AutoIncFactoryControler {
	
	enum ORDER_STATUS{STARTED, CONFIRMED, SHIPPING, COMPLETED}
	
	List<Product> showProducts();
	
	ProductDetails viewProductDetails(int productId);
	
	AvailabilityResponse checkProductAvailablity(int productId, String deliveryLocation);
	
	boolean registerUser(User user);
	
	CustomerDAO registerCustomer(int userId,String name,int contactNo,String city,String country,String zipcode,String addLine1,String addLine2);

	List<String> showTransportationTypes();
	
	DeliveryOffersDAO findCheapestSupplier(String preference);
	
	PurchaseDAO createOrder(int customerId, int productId, int supplier, double totalCost);

	List<PurchaseDAO> viewOrders();
}
