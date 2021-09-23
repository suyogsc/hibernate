package com.ucs.spring_hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ReadStudentDemo {
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session;
		session = factory.getCurrentSession();
		session.beginTransaction();

		Student student = new Student("Jack", "Mishra", "jack@gmail.com");
		session.save(student);
//	t.commit();
		System.out.println("successfully saved");
		session.getTransaction().commit();
		session.close();

		// find out the student primary key
		factory.getCurrentSession();
		session.beginTransaction();

		Student student2 = session.get(Student.class, student.getId());
		session.getTransaction().commit();
		session.close();
		System.out.println("ReadStudentDemo.main()" + student2);
		factory.close();

	}
}