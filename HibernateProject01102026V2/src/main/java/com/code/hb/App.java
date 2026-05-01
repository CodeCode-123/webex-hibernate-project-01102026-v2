package com.code.hb;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hb.demo.CreateCourse;
import com.code.hb.demo.CreateInstructor;
import com.code.hb.demo.DeleteInstructor;
import com.code.hb.demo.ReadInstructor;
import com.code.hb.demo.UpdateInstructor;
import com.code.hb.entity.Course;
import com.code.hb.entity.Instructor;
import com.code.hb.entity.InstructorProfile;
import com.code.hb.entity.Student;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// setup Dotenv to import environment variables
    	Dotenv dotenv=Dotenv.load();
        //System.out.println( "Hello World!" );
    	//create the object of the Configuration class
    	//annotation all the entity class
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
    			// set environment variables
    			.setProperty("hibernate.connection.username", dotenv.get("DB_USERNAME"))
    			.setProperty("hibernate.connection.password", dotenv.get("DB_PASSWORD"))
    			.addAnnotatedClass(Instructor.class)
    			.addAnnotatedClass(InstructorProfile.class)
    			.addAnnotatedClass(Course.class)
    			.addAnnotatedClass(Student.class)
    			.buildSessionFactory();
    	
    	//create the object of createInstructor
    	//new CreateInstructor(sessionFactory);
    	//new ReadInstructor(sessionFactory);
    	//new UpdateInstructor(sessionFactory);
    	//new DeleteInstructor(sessionFactory);
    	//new CreateCourse(sessionFactory);
    }
}
