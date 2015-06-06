package com.autoinc.businessControler;

import com.autoinc.bdo.Product;
import com.autoinc.dao.ProductDetailsDAO;
import com.autoinc.dao.WarehouseDAO;

public interface AutoIncAdminControler {
	void addProduct(Product newProduct);

	void addProductDetails(ProductDetailsDAO newProduct);

	void addWareHouse(WarehouseDAO warehouse);
}
