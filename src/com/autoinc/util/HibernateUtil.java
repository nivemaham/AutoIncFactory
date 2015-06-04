package com.autoinc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface HibernateUtil {
	
	String CONF_PATH="hibernate.cfg.xml";
	SessionFactory initialise();
	
	Session getSession();

}
