package org.ms.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ms.entities.DateUtils;
import org.ms.entities.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student s = new Student("Daffy","Duck","Daffy@hotmail.com",DateUtils.parseDate("31/12/1982"));
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			System.out.println("Done");
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Reading from database");
			Student myStudent = session.get(Student.class,s.getId());
			
			List<Student> myList = session
									.createQuery("FROM Student WHERE id>1")
									.getResultList();
			session.getTransaction().commit();
			System.out.println("Get complete:" + myStudent);
			
			
			for (Student myS : myList)
				System.out.println(myS.toString());
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
