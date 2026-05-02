package com.code.hb.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.hb.entity.*;

public class ReadStudent {
	SessionFactory sessionFactory;
	public ReadStudent(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//session object
		Session session=sessionFactory.getCurrentSession();
		//start the transaction, if use session, always start a transaction even if read
		session.beginTransaction();
		
		//write the query to get the student as well as the courses, JOIN FETCH
//		String hql="SELECT s FROM Student s JOIN FETCH s.courses"; 
//		List<Student> students =session.createQuery(hql, Student.class).getResultList();
//		for(Student student: students) {
//			System.out.println(student.toString());
//		}
		
		//write the query to get the student as well as the course
		List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();
		for(Student student: students) {
			System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
			System.out.println("Course Details");
			for(Course course: student.getCourses()) {
				System.out.println("Course Name: " + course.getTitle());
				System.out.println("Duration: " + course.getDuration());
				System.out.println("Fees: " + course.getFees());
				System.out.println("Instructor Name: " + course.getInstructor().getFirstName()+" "
				  + course.getInstructor().getLastName());
			}
		}
		
		//close the session object
		session.close();
	}

}
