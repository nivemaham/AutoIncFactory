package com.autoinc.businessControler;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
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
		
		findClosestWarehouse(deliveryLocation);
		return null;
	}

	private void findClosestWarehouse(String deliveryLocation) {
		Session session = hibernateUtil.getSession();
		session.beginTransaction();
//		WarehouseDAO query = session
//				.createSQLQuery("select wh from warehouse wh, address add where wh.OrderId = "+orderId).list();
//		
//		for(int i=0; i<query.size();i++){
//		if(query.get(i) instanceof Integer)
//		{
//			
//			Integer producerId = (Integer)query.get(i);
//			ids.add(producerId);
//		}
//		}
		session.getTransaction().commit();
		session.close();
		
	}

}
