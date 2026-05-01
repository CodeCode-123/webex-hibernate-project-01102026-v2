package com.code.hb.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.hb.entity.Course;
import com.code.hb.entity.Instructor;
import com.code.hb.entity.InstructorProfile;

public class CreateCourse {
	SessionFactory sessionFactory;
	public CreateCourse(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//session object
		Session session=sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//set the id instructor
		int id=3;
		//write the query to get the instructor as well as the instructor profile with id
		Instructor instructor = session.get(Instructor.class, id);
		if(instructor==null) {
			System.out.println("Instructor with id " + id + " not found");
			return;
		}
		//display the existing record
		InstructorProfile instructorProfile=session.get(InstructorProfile.class, id);
		System.out.println("Name: " + instructor.getFirstName() + " " + instructor.getLastName());
		System.out.println("Email id: " + instructor.getEmailId());
		System.out.println("Exp: " + instructorProfile.getExp());
		
		//create the object of the course
		Course course=new Course("Java", 2000, "15 hrs", instructor);
		//save the object
		session.save(course);
		//create the object of another course
		course=new Course("Advanced Java", 5000, "20 hrs", instructor);
		//save the object
		session.save(course);
		
		//commit to save it permanently into the table
		session.getTransaction().commit();
		//close the object
		session.close();
		//message
		System.out.println("Record is inserted successfully");
	}
}
