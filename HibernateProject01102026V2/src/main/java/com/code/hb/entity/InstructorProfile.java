package com.code.hb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_profile")
public class InstructorProfile {
	//member variables
	//mapped each member variable to the column with constraints
	//declared one of the member variable as PK
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="profile_id")
	private int profileId;
	@Column(name="qualification", length=20, nullable=false)
	private String quanlification;
	@Column(name="exp", length=20, nullable=false)
	private String exp;
	@Column(name="channel", length=50)
	private String channel;
	//create relationship with instructor one to one
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	//default constructor
	public InstructorProfile() {
		this.profileId=0;
		this.quanlification=null;
		this.exp=null;
		this.channel=null;
		this.instructor=null;
	}

	public InstructorProfile(String quanlification, String exp, String channel, Instructor instructor) {
		super();
		this.quanlification = quanlification;
		this.exp = exp;
		this.channel = channel;
		this.instructor = instructor;
	}
	//getter and setter method

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getQuanlification() {
		return quanlification;
	}

	public void setQuanlification(String quanlification) {
		this.quanlification = quanlification;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	//toString() method

	@Override
	public String toString() {
		return "InstructorProfile [profileId=" + profileId + ", quanlification=" + quanlification + ", exp=" + exp
				+ ", channel=" + channel + ", instructor=" + instructor + "]";
	}
}
