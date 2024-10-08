package com.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.Student;

public class DatabaseOperations {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Configuration configuration = new Configuration().configure(); // create Configuration object 
		SessionFactory sessionFactory = configuration.buildSessionFactory(); // create sessionfactory object
		Session session = sessionFactory.openSession(); // create session object
		session.beginTransaction(); //creating transaction
		
		System.out.println("___________________________________________________");
		System.out.println("\t >> get all deatails of Student: >>> 1");
		System.out.println("\t >> get Perticuler deatails of Student: >>> 2");
		System.out.println("\t >> update of Student college name: >>> 3");
		System.out.println("\t >> Remove of Student Details: >>> 4");
		System.out.println("\t Enter your option: ");
		byte option = sc.nextByte();
				
		switch (option) {
		/*
		 *  fetching all records
		 */
		case 1: // create execute query
				String hql= "FROM Student"; //user table name which is in database.
				Query query = session.createQuery(hql);
				List<Student> students = query.list();
		
				for (Student s : students) {
					System.out.println(
							"Student id: "+s.getStud_id()+
							"\nStudent Name: "+s.getStud_Name()+
							"\nStudent College name: "+s.getCollegeName()+
							"\nStudent CGPA: "+s.getCgpa()+"\n");
				}	
			break;
		/*
		 *  fetch single record 
		 */
		case 2 :
				System.out.println("Enter Student ID: ");
				Student s1 = session.get(Student.class, sc.nextInt());
				if (s1!=null) {
					System.out.println(
							"Student id: "+s1.getStud_id()+
							"\nStudent Name: "+s1.getStud_Name()+
							"\nStudent College name: "+s1.getCollegeName()+
							"\nStudent CGPA: "+s1.getCgpa());
				} else {
					System.out.println("\t ***** not data found *****");
				}
			break;
		/*
		 *  updating Student records by with out using HQL and SQL Query 
		 */
		case 3 :
				Student s2;
				try {
					System.out.println("Enter Student ID: ");
					s2 = session.get(Student.class, sc.nextInt());
					sc.nextLine();
					System.out.println("Enter new College Name: ");
					String newClgName = sc.nextLine();
					s2.setCollegeName(newClgName);
					session.update(s2);
						System.out.println("\t ****** Student COllege updated ******\n Student ");
						System.out.println(
								"Student id: "+s2.getStud_id()+
								"\nStudent Name: "+s2.getStud_Name()+
								"\nStudent College name: "+s2.getCollegeName()+
								"\nStudent CGPA: "+s2.getCgpa());
				} catch (Exception e) {
					System.out.println("\t****details not found *******");
					e.printStackTrace();
				}
				
			break;
		/*
		 *  Remove record from the table
		 */
		case 4: 
				Student s3 = session.get(Student.class, 1);
//				session.remove(s3);
				session.remove(s3); // can use delete also
				if (s3!=null) {
					System.out.println("\t Data deleted");
				} else {
					System.out.println("\t data not found");
				}
		break;
		default:  System.out.println("\t ********* invalid entry *********");
			break;
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}