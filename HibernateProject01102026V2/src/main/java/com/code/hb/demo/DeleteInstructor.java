package com.code.hb.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.hb.entity.Instructor;
import com.code.hb.entity.InstructorProfile;

public class DeleteInstructor {
	SessionFactory sessionFactory;
	public DeleteInstructor(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//session object
		Session session=sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//set the id instructor
		int id=1;
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
		
		//remove the object, use .remove(), delete() is deprecated
		session.remove(instructor);
		//commit
		session.getTransaction().commit();
		//close the session object
		session.close();
		//message
		System.out.println("Record is deleted successfully");
	}

}
