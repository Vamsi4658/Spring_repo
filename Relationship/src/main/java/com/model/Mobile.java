package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int MobileId;
	private String brand;
	
	@ManyToOne
    @JoinColumn(name = "person_id")
	private Person person;
	
	public int getMobileId() {
		return MobileId;
	}

	public void setMobileId(int mobileId) {
		MobileId = mobileId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
