package com.autoinc.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.autoinc.dao.AddressDAO;



public class Main {
public static void main(String arg[])
{
	AddressDAO a= new AddressDAO();
	a.setAddLine1("Hind Nagar");
	a.setAddLine2("Hidcnd Nagar");
	a.setCity("Lucknow");
	a.setCountry("India");
	a.setZipcode("aaaaaaa");
	
	
	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(builder.build()); 


		Session session=factory.openSession();
		session.beginTransaction();
		session.save(a);
		
		session.getTransaction().commit();
		session.close();
		
		
		}

	
	}
