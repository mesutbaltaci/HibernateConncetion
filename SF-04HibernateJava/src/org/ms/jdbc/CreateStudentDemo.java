package org.ms.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ms.entities.DateUtils;
import org.ms.entities.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student s = new Student("Mesut","Baltaci","mesutbaltaci@hotmail.com",DateUtils.parseDate("31/12/1982"));
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			System.out.println("Done");
			session.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
