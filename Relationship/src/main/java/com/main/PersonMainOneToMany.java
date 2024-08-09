package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Aadhar;
import com.model.Mobile;
import com.model.Person;

public class PersonMainOneToMany {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Person person = new Person();
		
		//creating mobile object
		Mobile m1 = new Mobile();
		m1.setBrand("samasung");
		m1.setPerson(person);
		
		Mobile m2 = new Mobile();
		m2.setBrand("iPhone");
		m2.setPerson(person);
		
		// creating aadhar object 
		Aadhar aadhar =new Aadhar();
		aadhar.setIssuedBy("AP");
		
		//passing person details
		person.setPersonName("Manoj");
		person.setAadhar(aadhar);
		// adding list of mobile to person
		person.getMobile().add(m1);
		person.getMobile().add(m2);
		
		
		//save object 
		session.save(m1);
		session.save(m2);
		session.save(aadhar);
		session.save(person);
		
		// close session
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
