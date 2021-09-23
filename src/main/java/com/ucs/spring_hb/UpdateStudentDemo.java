package com.ucs.spring_hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// query Student
		List<Student> theStudent = session.createQuery("from Student").list();
		// display the students
		displayStudents(theStudent);
		// query student :lastName='Maurya'
		theStudent = session.createQuery("from Student s where s.lastName='maurya'").list();
		// display the student
		System.out.println("\n\n Students who have last name maurya");
		displayStudents(theStudent);
		// query students: lastName as 'Dao' or firstName='Daffy
		
		// query students where email Like'%luv2code.com'
		theStudent = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();
		displayStudents(theStudent);
		t.commit();
		System.out.println("successfully getting record.");
		factory.close();
		session.close();

	}

	private static void displayStudents(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}
}