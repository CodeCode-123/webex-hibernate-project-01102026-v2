package com.code.hb.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.hb.entity.Course;
import com.code.hb.entity.Instructor;
import com.code.hb.entity.InstructorProfile;
import com.code.hb.entity.Student;

public class CreateStudent {
	SessionFactory sessionFactory;
	public CreateStudent(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//session object
		Session session=sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//get all the Courses we have
		List<Course> courses=session.createQuery("FROM Course", Course.class).getResultList();
		if(courses.size()==0) {
			System.out.println("Course not found. Please create the course");
			return;
		}
		
		//create the object of the Student
		Student student=new Student("Test", "Test1", "test@gmail.com");
		//student take admission in course
		Course course = courses.stream().filter(c -> c.getTitle().equalsIgnoreCase("java")).findAny().orElse(null);
		if (course != null) {
			//add the course
			student.addCourse(course);
		}
		course=courses.stream().filter(c -> c.getTitle().equalsIgnoreCase("advanced java")).findAny().orElse(null);
		if (course != null) {
			//add the course
			student.addCourse(course);
		}
		//save the object
		session.save(student);
		
		//commit to save it permanently into the table
		session.getTransaction().commit();
		//close the object
		session.close();
		//message
		System.out.println("Record is inserted successfully");
	}
}
