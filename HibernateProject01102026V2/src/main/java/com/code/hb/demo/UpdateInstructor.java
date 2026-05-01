package com.code.hb.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.hb.entity.Instructor;
import com.code.hb.entity.InstructorProfile;

public class UpdateInstructor {
	SessionFactory sessionFactory;
	public UpdateInstructor(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//session object
		Session session=sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//set the id instructor
		int id=2;
		//write the query to get the instructor as well as the instructor profile with id
		InstructorProfile instructorProfile=session.get(InstructorProfile.class, id);
		if(instructorProfile==null) {
			System.out.println("Instructor with id " + id + " not found");
			return;
		}
		//display the existing record
		Instructor instructor = instructorProfile.getInstructor();
		System.out.println("Name: " + instructor.getFirstName() + " " + instructor.getLastName());
		System.out.println("Email id: " + instructor.getEmailId());
		System.out.println("Exp: " + instructorProfile.getExp());
		
		//update the old values with the new values
		instructorProfile.getInstructor().setFirstName("Mary Edit");
		instructorProfile.setExp("5 yrs exp");
		//save the object
		session.save(instructorProfile);
		//commit
		session.getTransaction().commit();
		//close the session object
		session.close();
		//message
		System.out.println("Record is updated successfully");
	}

}
