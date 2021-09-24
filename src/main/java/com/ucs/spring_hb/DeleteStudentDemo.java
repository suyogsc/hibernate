package com.ucs.spring_hb;

import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DeleteStudentDemo {


	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
	
		// query Student
		Student theStudent = session.get(Student.class, 4);
	
		//session.delete(theStudent);
		session.remove(theStudent);
		//System.out.println(session.createQuery("delete from Student where id=3").executeUpdate());
		
		t.commit();
		System.out.println("successfully deleting  record.");
		factory.close();
		session.close();

	}

	private static void displayStudents(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
