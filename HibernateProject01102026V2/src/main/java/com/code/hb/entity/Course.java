package com.code.hb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int courseId;
	@Column(name="title",length=50,nullable=false,unique=true)
	private String title;
	@Column(name="fees", nullable=false)
	private double fees;
	@Column(name="duration", length=20, nullable=false)
	private String duration;
	//create a relationship with instructor ManyToOne
	@ManyToOne
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	public Course() {
		this.courseId=0;	
	}
	// constructor with parameters
	public Course(String title, double fees, String duration, Instructor instructor) {
		super();
		this.title = title;
		this.fees = fees;
		this.duration = duration;
		this.instructor = instructor;
	}
	
	// getter and setter
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	// toString() method
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", fees=" + fees + ", duration=" + duration
				+ ", instructor=" + instructor + "]";
	}
}
