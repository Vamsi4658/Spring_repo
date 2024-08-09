package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Aadhar;
import com.model.Person;

public class PersonMainOneToOne {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Aadhar aadhar = new Aadhar();
		aadhar.setIssuedBy("Tamilnadu");
		
		Person person = new Person();
		person.setPersonName("Vignash");
		person.setAadhar(aadhar);
		
		session.save(person);
		session.save(aadhar);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
