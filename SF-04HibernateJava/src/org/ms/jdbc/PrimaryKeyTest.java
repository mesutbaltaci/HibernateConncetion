package org.ms.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ms.entities.DateUtils;
import org.ms.entities.Student;

public class PrimaryKeyTest {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();
				
				try {
				
				Student s1 = new Student("Kamil","Baltaci","Kamil@hotmail.com",DateUtils.parseDate("31/12/1982"));
				Student s2 = new Student("Hasan","Baltaci","Hasan@hotmail.com",DateUtils.parseDate("31/12/1982"));
				Student s3 = new Student("Jason","Baltaci","Jason@hotmail.com",DateUtils.parseDate("31/12/1982"));
				session.beginTransaction();
				
				session.save(s1);
				session.save(s2);
				session.save(s3);
				
				session.getTransaction().commit();
				System.out.println("Done");
				} catch (Exception e) {
				e.getStackTrace();
				}
				finally {
				factory.close();
}

	}

}
