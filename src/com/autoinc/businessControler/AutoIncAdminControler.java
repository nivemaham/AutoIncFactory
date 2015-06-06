package com.autoinc.businessControler;

import com.autoinc.bdo.Product;
import com.autoinc.dao.DeliveryOffersDAO;
import com.autoinc.dao.ProductDetailsDAO;
import com.autoinc.dao.SupplyLogisticsDAO;
import com.autoinc.dao.WarehouseDAO;

public interface AutoIncAdminControler {
	
	enum DELIVERY_SERVICE_LEVEL{HOME_DELIVERY, IMMEDIATE_DELIVERY, CENTRALISED_DELIVERY}
	void addProduct(Product newProduct);

	void addProductDetails(ProductDetailsDAO newProduct);

	void addWareHouse(WarehouseDAO warehouse);

	void addSuppliers(SupplyLogisticsDAO supplier);
	
	void addDeliveryOffers(DeliveryOffersDAO deliveryOffers);
}
