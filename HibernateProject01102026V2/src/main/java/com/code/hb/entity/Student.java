package com.code.hb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	@Column(name="first_name", length=20, nullable=false)
	private String firstName;
	@Column(name="last_name", length=20, nullable=false)
	private String lastName;
	@Column(name="email_id", length=50, nullable=false, unique=true)
	private String emailId;
	//create a relationship with course ManyToMany
	@ManyToMany
	@JoinTable(name="student_course", joinColumns=@JoinColumn(name="student_id"), 
	           inverseJoinColumns=@JoinColumn(name="course_id"))
	List<Course> courses;
	
	public Student() {
		this.studentId=0;
	}

	public Student(String firstName, String lastName, String emailId, List<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.courses = courses;
	}
	
	// getter and setter
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	// create one method to add the course
	public void addCourse(Course course) {
		//the object of courses is created or not
		if (courses == null) {
			// create the new object
			courses = new ArrayList<Course>();
		}
		//add the course to the courses
		courses.add(course);
	}

	// toString() method
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", courses=" + courses + "]";
	}
}
