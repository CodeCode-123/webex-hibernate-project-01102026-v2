package com.code.hb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	//member variables
	//mapped each member cariable to the column with constraints
	//declared one of the member variable as PK
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name", length=20, nullable=false)
	private String firstName;
	@Column(name="last_name", length=20, nullable=false)
	private String lastName;
	@Column(name="email_id", length=50, nullable=false, unique=true)
	private String emailId;
	
	// default constructor
	public Instructor() {
		this.id=0;
		this.firstName=null;
		this.lastName=null;
		this.emailId=null;
	}
	// constructor with parameter
	public Instructor(String firstName, String lastName, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	// getter and setter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	//toString() method
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}
}
