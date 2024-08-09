package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class EmplyeeImp implements EmployeeInterface {

//	private Employee employee;
	
	Configuration configuration = new Configuration().configure();
	
	public void addEmployeeDetails() {
	
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmp_Name("vamsi Savarapu");
		employee.setEmp_mobile_num("8096166376");		employee.setSalary(300000);
//		employee.setDate_Of_Join("2022-03-23");
		
		session.save(employee);
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
	
	

}
