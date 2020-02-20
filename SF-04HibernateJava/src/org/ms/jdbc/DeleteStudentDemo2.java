package org.ms.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ms.entities.Student;

public class DeleteStudentDemo2 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int studentId=1;
			session.beginTransaction();
			Student s = session.get(Student.class, studentId);
			session.delete(s);
			session.getTransaction().commit();
			System.out.println("Done");
			
			
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student WHERE id>5")
									.executeUpdate();
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
