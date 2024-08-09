package com.main;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Course;
import com.model.Mobile;
import com.model.Person;

public class DataBaseOperationOnToMany {

	public static void main(String[] args) {
		
		Configuration configuration =new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();

	        List<Person> persons = session.createQuery("From Person").list();

	        for (Person p : persons) {
	            System.out.println("Person id: " + p.getPerson_id());
	            System.out.println("Person name: " + p.getPersonName());
	            System.out.println("Person aadhar: " + p.getAadhar().getIssuedBy());

	            if (p.getMobile() != null) {
	            	
	                for (Mobile m : p.getMobile()) {System.out.println("Person mobile brand name: " + m.getBrand() + "\n");}
	                
	            } else {
	                System.out.println("No mobile details found for person id: " + p.getPerson_id());
	            }

	            if (p.getCourse() != null) {
	            	
	                for (Course course : p.getCourse()) {
	                    System.out.println("Course: " + course.getCourseName());
	                }
	            } else {
	                System.out.println("No course details found for person id: " + p.getPerson_id());
	            }
	            System.out.println("\n\n");
	        }

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        sessionFactory.close();
	    }
	}
}
