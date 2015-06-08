package com.autoinc.businessControler;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.autoinc.bdo.AvailabilityResponse;
import com.autoinc.bdo.Product;
import com.autoinc.bdo.ProductDetails;
import com.autoinc.bdo.User;
import com.autoinc.businessControler.AutoIncAdminControler.DELIVERY_SERVICE_LEVEL;
import com.autoinc.dao.AddressDAO;
import com.autoinc.dao.CustomerDAO;
import com.autoinc.dao.DeliveryOffersDAO;
import com.autoinc.dao.PurchaseDAO;
import com.autoinc.dao.ProductDAO;
import com.autoinc.dao.ProductDetailsDAO;
import com.autoinc.dao.SupplyLogisticsDAO;
import com.autoinc.dao.UserDAO;
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
		session.saveOrUpdate(new UserDAO(user));
		session.getTransaction().commit();
		session.close();

		return true;

	}

	@Override
	public AvailabilityResponse checkProductAvailablity(int productId,
			String deliveryLocation) {

		WarehouseDAO warehouse = findClosestWarehouse(deliveryLocation);

		WarehouseDAO alternativewarehouse = findAlternativeWarehouse(warehouse);

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
		WarehouseDAO results = (WarehouseDAO) query.uniqueResult();
		session.getTransaction().commit();
		session.close();

		return results;

	}

	@Override
	public CustomerDAO registerCustomer(int userId, String name, int contactNo,
			String city, String country, String zipcode, String addLine1,
			String addLine2) {

		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		
		UserDAO userObj = (UserDAO) session.get(
				UserDAO.class, userId);
		AddressDAO address = new AddressDAO();

		address.setAddLine1(addLine1);
		address.setAddLine2(addLine2);
		address.setCity(city);
		address.setCountry(country);
		address.setZipcode(zipcode);
		
		CustomerDAO customer = new CustomerDAO();
		customer.setUser(userObj);
		customer.setName(name);
		customer.setAddress(address);
		customer.setContactNumber(contactNo);
		
		session.save(address);
		session.save(customer);
		session.getTransaction().commit();

		return customer;
	}
	
	@Override
	public List<String> showTransportationTypes() {
		// TODO Auto-generated method stub
		List<String> transportationTypes = new ArrayList<String>();
		for (DELIVERY_SERVICE_LEVEL type : AutoIncAdminControler.DELIVERY_SERVICE_LEVEL
				.values()) {
			transportationTypes.add(type.toString());
		}
		return transportationTypes;
	}

	@Override
	public DeliveryOffersDAO findCheapestSupplier(String preference) {

		Session session = hibernateUtil.getSession();
		session.beginTransaction();

		String hql = "SELECT SUP FROM DeliveryOffersDAO SUP "
				+ "group by SUP.serviceLevel having SUP.serviceLevel in (:preference) and min(SUP.costPerUnit)<10000.0";
		Query query = session.createQuery(hql);
		query.setParameter("preference", preference.trim());
		DeliveryOffersDAO results = (DeliveryOffersDAO) query.uniqueResult();
		// System.out.println(" size "+results.size());
		session.getTransaction().commit();
		session.close();

		return results;
	}

	@Override
	public PurchaseDAO createOrder(int customerId, int productId, int supplierId,
			double totalCost) {
		PurchaseDAO newOrder = new PurchaseDAO();

		Session session = hibernateUtil.getSession();
		session.beginTransaction();

		CustomerDAO customer = (CustomerDAO) session.get(CustomerDAO.class,
				customerId);

		ProductDAO product = (ProductDAO) session.get(ProductDAO.class,
				productId);

		SupplyLogisticsDAO supplierObj = (SupplyLogisticsDAO) session.get(
				SupplyLogisticsDAO.class, supplierId);

		newOrder.setCustomer(customer);
		newOrder.setProduct(product);
		newOrder.setSupplier(supplierObj);
		newOrder.setTotalCost(totalCost);
		newOrder.setOrderStatus(AutoIncFactoryControler.ORDER_STATUS.STARTED
				.toString());

		session.save(newOrder);
		session.getTransaction().commit();
		session.close();

		return null;
	}
	
	public List<PurchaseDAO> viewOrders(){
		Session session = hibernateUtil.getSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<PurchaseDAO> listProd = (List<PurchaseDAO>) session
				.createCriteria(PurchaseDAO.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		session.close();
		
		return listProd;
	}
}
