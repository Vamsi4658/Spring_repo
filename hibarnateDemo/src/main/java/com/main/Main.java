package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Address;
import com.model.Student;

public class Main {

	public static void main(String[] args) {
	
		// create configuration Object
		Configuration configuration = new Configuration().configure();
		
		// create session factory object
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//create Session Object
		Session session = sessionFactory.openSession();
		
		// create Transaction instance
		session.beginTransaction();
		
		Student s1 = new Student();
////		s1.setStud_id(100); // no need to pass id value because it is auto incremented
		s1.setStud_Name("Vamsi Savarapu");
		s1.setCollegeName("Pragati Engineering College");
		s1.setCgpa(7.24);
//		
//		session.save(s1);
		
		Address hA = new Address();
		hA.setStreet("Bhanugudi street");
		hA.setCity("Kakinada");
		hA.setState("Andhra Pradhesh");
		hA.setPincode("533005");
		
		Address oA = new Address();
		oA.setStreet("LB Road");
		oA.setCity("Chennai");
		oA.setState("Tamilnadu");
		oA.setPincode("600041");
		
		s1.setHomeAddress(hA);
		s1.setOfficeAddress(oA);
		
		session.save(s1);
		
		//commit the transaction
		session.getTransaction().commit();
		
		//close the session
		session.close();
		
		//close the session factory
		sessionFactory.close();
	}
}
