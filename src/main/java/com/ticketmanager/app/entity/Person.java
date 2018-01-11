package com.ticketmanager.app.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Person_Table")
@NamedQueries( value = {
	@NamedQuery(name="Person.findFirstNameByAadharNumber",query = "select p from Person p where p.aadharNumber =?1 "),
	@NamedQuery(name="Person.findFirstNameAndLastNameByMaritalStatus",query="select p from Person p where p.married =?1") 
})
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "person_id")
	private int personId;
	
	@Column(name = "first_name",nullable =false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "pan_number",nullable=false)
	private String panNumber;
	
	@Column(name = "aadahr_number",nullable=false,unique=true)
	private String aadharNumber;
	
	@Column(name="sex",length=1,nullable=false)
	private char sex;
	
	@Column(name = "is_married",nullable=false)
	private boolean married;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}
	
	
	

}
