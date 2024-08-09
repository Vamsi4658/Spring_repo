package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Aadhar;
import com.model.Course;
import com.model.Mobile;
import com.model.Person;

public class PersonManyToMany {

	public static void main(String[] args) {
	
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 // Creating Course instances
	    Course c1 = new Course();
	    Course c2 = new Course();
	    Course c3 = new Course();
	    
	    // Creating Person instances
	    Person p1 = new Person();
	    Person p2 = new Person();
	    
	    // Creating Aadhar instances
	    Aadhar a1 = new Aadhar();
	    Aadhar a2 = new Aadhar();
	    
	    // Creating Mobile instances
	    Mobile m1 = new Mobile();
	    Mobile m2 = new Mobile();
	    
	    // Setting Course names
	    c1.setCourseName("Java");
	    c2.setCourseName("Python");
	    c3.setCourseName("ReactJs");
	    
	    // Setting Aadhar issuedBy
	    a1.setIssuedBy("MH");
	    a2.setIssuedBy("KL");
	    
	    // Setting Mobile brands
	    m1.setBrand("Mi");
	    m2.setBrand("Nokia");
	    
	    // Setting Person 1 properties
	    p1.setPersonName("Ilavarasan");
	    p1.setAadhar(a1);
	    p1.getMobile().add(m1);
	    p1.getCourse().add(c1);
	    p1.getCourse().add(c2);
	    
	    // Setting Person 2 properties
	    p2.setPersonName("Marcus");
	    p2.setAadhar(a2);
	    p2.getMobile().add(m2);
	    p2.getCourse().add(c2);
	    p2.getCourse().add(c3);
	    
	    // Save objects
	    session.save(p1);
	    session.save(p2);
	    session.save(c1);
	    session.save(c2);
	    session.save(c3);
	    session.save(a1);
	    session.save(a2);
	    session.save(m1);
	    session.save(m2);
	    
	    session.getTransaction().commit();
	    session.close();
	    sessionFactory.close();
	}
}
