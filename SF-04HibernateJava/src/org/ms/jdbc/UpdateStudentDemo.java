package org.ms.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ms.entities.DateUtils;
import org.ms.entities.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int studentId=3;
			session.beginTransaction();
			Student s = session.get(Student.class, studentId);
			s.setFirstName("Sadiye");			
			s.setLastName("teyze");
			s.setDateOfBirth(DateUtils.parseDate("31/12/1992"));
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
