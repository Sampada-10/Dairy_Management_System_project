package com.Utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.Entity.Customer;
import com.Entity.DairyOwner;
import com.Entity.Supplier;


public class MySQLConfiguration {

	public static SessionFactory sessionfactory;

	public static SessionFactory getSession() {
		try {

			Properties setting = new Properties();
			setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); // Setup the driver
			setting.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate"); // Setup the URL
			setting.put(Environment.USER, "root"); // Setup a username
			setting.put(Environment.PASS, "Swapnil@123"); // Setup a password of mysql
			setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");// It is bridge between sql types
																					// and jdbc types
			setting.put(Environment.FORMAT_SQL, "true");
			setting.put(Environment.SHOW_SQL, "true"); // It shows sql query on terminal
			setting.put(Environment.HBM2DDL_AUTO, "update");
			setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			
			Configuration cfg = new Configuration();		
			cfg.setProperties(setting);
			
			cfg.addAnnotatedClass(Customer.class);//Use for mapping Customer class
			cfg.addAnnotatedClass(Supplier.class);//Use for mapping Supplier class
			cfg.addAnnotatedClass(DairyOwner.class);//Use for mapping Admin class

			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build();
			sessionfactory = cfg.buildSessionFactory(ssr);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sessionfactory;
	}
}
