package com.autoinc.businessControler;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.autoinc.bdo.AvailabilityResponse;
import com.autoinc.bdo.Product;
import com.autoinc.bdo.ProductDetails;
import com.autoinc.bdo.User;
import com.autoinc.dao.ProductDAO;
import com.autoinc.dao.ProductDetailsDAO;
import com.autoinc.dao.WarehouseDAO;
import com.autoinc.util.HibernateUtil;
import com.autoinc.util.HibernateUtilImpl;

public class AutoIncFactoryControlerImpl implements AutoIncFactoryControler {

	HibernateUtil hibernateUtil = new HibernateUtilImpl();

	@Override
	public List<Product> showProducts() {
		Session session = hibernateUtil.getSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<ProductDAO> listProd = (List<ProductDAO>) session
				.createCriteria(ProductDAO.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		session.close();

		return convertToProducts(listProd);
	}

	private List<Product> convertToProducts(List<ProductDAO> listProd) {
		List<Product> products = new ArrayList<>();
		for (ProductDAO prodDao : listProd) {
			products.add(new Product(prodDao));
		}
		return products;
	}

	@Override
	public ProductDetails viewProductDetails(int productId) {

		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		ProductDetailsDAO productDetails = (ProductDetailsDAO) session.get(
				ProductDetailsDAO.class, productId);
		session.getTransaction().commit();
		session.close();

		return new ProductDetails(productDetails);
	}

	@Override
	public boolean registerUser(User user) {
		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
		
		return true;

	}

	@Override
	public AvailabilityResponse checkProductAvailablity(int productId, String deliveryLocation) {
		
		WarehouseDAO warehouse = findClosestWarehouse(deliveryLocation);
		
		WarehouseDAO alternativewarehouse =findAlternativeWarehouse(warehouse);
		
		System.out.println(alternativewarehouse.getAddress().getCountry());
		return null;
	}

	private WarehouseDAO findAlternativeWarehouse(WarehouseDAO warehouse) {
		Session session = hibernateUtil.getSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<WarehouseDAO> listProd = (List<WarehouseDAO>) session
				.createCriteria(WarehouseDAO.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		session.close();

		listProd.remove(warehouse);
		return listProd.get(0);
	}

	private WarehouseDAO findClosestWarehouse(String deliveryLocation) {
		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		
		String hql = "SELECT WH FROM AddressDAO E, WarehouseDAO WH WHERE WH.address = E.id and E.country=:addCountry";
		Query query = session.createQuery(hql);
		query.setParameter("addCountry", deliveryLocation.trim());
		WarehouseDAO results = (WarehouseDAO)query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		return results;
		
	}

}
