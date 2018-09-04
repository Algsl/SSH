package com.myproject.hello.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory factory;
	private static Configuration conf;
	
	static {
		conf=new Configuration();
		conf.configure();
		factory=conf.buildSessionFactory();
	}
	public static Session getSession() {
		return factory.getCurrentSession();
	}
	
}
