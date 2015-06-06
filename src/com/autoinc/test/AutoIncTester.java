package com.autoinc.test;

import com.autoinc.businessControler.AutoIncAdminControler;
import com.autoinc.businessControler.AutoIncAdminControlerImpl;
import com.autoinc.dao.AddressDAO;
import com.autoinc.dao.DeliveryOffersDAO;
import com.autoinc.dao.SupplyLogisticsDAO;

public class AutoIncTester {

	public static void main(String[] args) {
		
//		ProductDAO product = new ProductDAO();
//		product.setBrand("AutoInc");
//		product.setColor("Red");
//		product.setManufacturer("Asian Regional MHQ");
//		product.setModelnumber("KZ240");
//		product.setPrice(25000);
//		product.setImageurl("imageUrl");
////		
//		AutoIncFactoryControler controler = new AutoIncFactoryControlerImpl();
//		
//		controler.addProduct(product);
//		List<Product> products = controler.showProducts();
//		System.out.println(products.get(0).toString());
		
//		ProductDetailsDAO productDetails = new ProductDetailsDAO();
//		productDetails.setProduct(product);
//		productDetails.setBodyStyle("sport");
//		productDetails.setEngine("c3000");
//		productDetails.setMileage(800);
//		productDetails.setType("aliance");
		
//		AddressDAO addressDAO = new AddressDAO();
//		addressDAO.setAddLine1(" Champ de Mars ");
//		addressDAO.setAddLine2("5 Avenue Anatole France");
//		addressDAO.setCity("Paris ");
//		addressDAO.setCountry("France");
//		addressDAO.setZipcode("75007 ");
//		
//		WarehouseDAO wh = new WarehouseDAO();
//		wh.setAddress(addressDAO);
//		wh.setCapacity(100);
//		wh.setServiceUrl("http:localhost:otherurl");
//		
		AutoIncAdminControler admincontroler = new AutoIncAdminControlerImpl();
//		admincontroler.addWareHouse(wh);
//		admincontroler.addProductDetails(productDetails);
		
		SupplyLogisticsDAO supplier = new SupplyLogisticsDAO();
		supplier.setLocation(new AddressDAO(6, "New supplier 1", "79, Fake street", "Pisa", "Italy", "70569"));
		supplier.setServiceUrl("someUrl");
		supplier.setSupplierName("edEx");
		supplier.setId(3);
		
//		admincontroler.addSuppliers(supplier);
		
		DeliveryOffersDAO deliveryOffer = new DeliveryOffersDAO();
		deliveryOffer.setSupplier(supplier);
		deliveryOffer.setServiceLevel(AutoIncAdminControler.DELIVERY_SERVICE_LEVEL.HOME_DELIVERY.name());
		deliveryOffer.setCostPerUnit(50.0f);

		admincontroler.addDeliveryOffers(deliveryOffer);
		
//		ProductDetails prodDetails = controler.viewProductDetails(2);
//		System.out.println(prodDetails.getBodyStyle()+" "+prodDetails.getProduct().getBrand());

		
//		controler.checkProductAvailablity(2, "France");
	}

}
