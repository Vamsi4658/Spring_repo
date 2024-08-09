package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.type.TrueFalseType;

/*
 *  one-to-one
 */
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int person_id;
	private String personName;
	/*
	 *  one person have a one aadhar number at that time make use of one-to-one annotation
	 */
	@OneToOne
	@JoinColumn(name = "aadhar_id")
	private Aadhar aadhar;
	
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	private List<Mobile> mobile = new ArrayList<Mobile>();
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "person_course",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> course = new ArrayList<Course>();
    
    
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public int getPerson_id() {
		return person_id;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Aadhar getAadhar() {
		return aadhar;
	}
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	
	
}
