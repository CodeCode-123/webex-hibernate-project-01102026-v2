package com.code.hb.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.hb.entity.Instructor;
import com.code.hb.entity.InstructorProfile;

public class ReadInstructor {
	SessionFactory sessionFactory;
	public ReadInstructor(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//session object
		Session session=sessionFactory.getCurrentSession();
		//start the transaction, if use session, always start a transaction even if read
		session.beginTransaction();
		//write the query to  get the instructor as well as the instructor profile
		String hql="SELECT i FROM Instructor i JOIN FETCH i.instructorProfile"; 
		List<Instructor> instructors =session.createQuery(hql, Instructor.class).getResultList();
		
		for(Instructor instructor: instructors) {
			System.out.println(instructor.toString());
		}
		//close the session object
		session.close();
	}

}
