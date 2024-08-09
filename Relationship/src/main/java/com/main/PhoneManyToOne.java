package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Aadhar;
import com.model.Mobile;
import com.model.Person;

public class PhoneManyToOne {

	public static void main(String[] args) {
		/*
		 *  ->  
		 */
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/*
		 *   object creating
		 */
		Mobile m1 = new Mobile();
		Mobile m2 = new Mobile();
		Person person = new Person();
		Aadhar aadhar = new Aadhar();
		
		m1.setBrand("Realme");
		m2.setBrand("Sony");
		// object creation
		aadhar.setIssuedBy("TS");
		
		person.setPersonName("Abdul");
		person.setAadhar(aadhar);
		person.getMobile().add(m1);
		person.getMobile().add(m2);
		
		m1.setPerson(person);
		m2.setPerson(person);
		
		session.save(person);
		session.save(aadhar);
		session.save(m1);
		session.save(m2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
