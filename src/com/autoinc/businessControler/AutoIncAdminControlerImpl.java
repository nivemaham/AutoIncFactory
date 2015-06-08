package com.autoinc.businessControler;

import org.hibernate.Session;

import com.autoinc.bdo.Product;
import com.autoinc.dao.DeliveryOffersDAO;
import com.autoinc.dao.ProductDAO;
import com.autoinc.dao.ProductDetailsDAO;
import com.autoinc.dao.SupplyLogisticsDAO;
import com.autoinc.dao.WarehouseDAO;
import com.autoinc.util.HibernateUtil;
import com.autoinc.util.HibernateUtilImpl;

public class AutoIncAdminControlerImpl implements AutoIncAdminControler{
	
	HibernateUtil hibernateUtil = new HibernateUtilImpl();
	
	@Override
	public void addProduct(Product newProduct) {
		
			Session session = hibernateUtil.getSession();
			session.beginTransaction();
			session.saveOrUpdate(new ProductDAO(newProduct));
			session.getTransaction().commit();
			session.close();
	}

	@Override
	public void addProductDetails(ProductDetailsDAO newProduct) {
		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(newProduct.getProduct());
		session.saveOrUpdate(newProduct);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void addWareHouse(WarehouseDAO warehouse) {
		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(warehouse.getAddress());
		session.saveOrUpdate(warehouse);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void addSuppliers(SupplyLogisticsDAO supplier) {
		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(supplier.getLocation());
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void addDeliveryOffers(String servicelevel, int supplierId, float costPerUnit) {
		
		
		
		DeliveryOffersDAO deliveryOffers = new DeliveryOffersDAO();
		
		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		SupplyLogisticsDAO supplier = (SupplyLogisticsDAO) session.get(
				SupplyLogisticsDAO.class, supplierId);
		deliveryOffers.setSupplier(supplier);
		deliveryOffers.setCostPerUnit(costPerUnit);
		deliveryOffers.setServiceLevel(servicelevel);
		
		session.saveOrUpdate(deliveryOffers.getSupplier());
		session.saveOrUpdate(deliveryOffers);
		session.getTransaction().commit();
		session.close();
	}


}
