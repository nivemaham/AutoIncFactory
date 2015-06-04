package com.autoinc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtilImpl implements HibernateUtil{

	private SessionFactory factory;
	private Configuration configuration; 
	@Override
	public SessionFactory initialise() {
		if(factory ==null )
		{
			configuration = new Configuration();
			factory =configuration.configure()
            .buildSessionFactory(
                 new StandardServiceRegistryBuilder()  
                    .applySettings(configuration.getProperties())
                    .build());
		}
		 
        return factory; 
	}
	@Override
	public Session getSession() {
		return initialise().openSession();
	}

}
