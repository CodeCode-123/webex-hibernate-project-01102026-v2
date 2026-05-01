package com.code.hb.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.hb.entity.Instructor;
import com.code.hb.entity.InstructorProfile;

public class CreateInstructor {
	SessionFactory sessionFactory;
	public CreateInstructor(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//session object
		Session session=sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//create the object of the instructor
		Instructor instructor=new Instructor("John", "Doe", "john@abc.com");
		//save the object, the instructorProfile needs the created instructorId
		session.save(instructor);
		//create the object of the instructor profile
		InstructorProfile instructorProfile=new InstructorProfile("M-tech", "1 yr exp", "youtube.com?name=john", instructor);
		//save the object
		session.save(instructorProfile);
		
		//create the object of another instructor
		instructor=new Instructor("Mary", "Williams", "mary1@abc.com");
		//save the object, the instructorProfile needs the created instructorId
		session.save(instructor);
		//create the object of the instructor profile
		instructorProfile=new InstructorProfile("M-tech", "2 yr exp", "youtube.com?name=mary", instructor);
		//save the object
		session.save(instructorProfile);
		//commit to save it permanently into the table
		session.getTransaction().commit();
		//close the object
		session.close();
		//message
		System.out.println("Record is inserted successfully");
	}
}
