package com.rockstar.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="subscriberInfo")
public class SubscriberInfo {

	
	@Id
	private int rmn;
	private String title;
	private String firstname;
	private String middlename;
	private String lastname;
	private String gender;

	private int contact;
	private String email;
	
	@OneToOne
	@JoinColumn(name="addressInfo")
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public SubscriberInfo() {
		super();
	}
	public SubscriberInfo(int rmn, String title, String firstname, String middlename, String lastname, String gender,
			int contact, String email) {
		super();
		this.rmn = rmn;
		this.title = title;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
	
	}
	public int getRmn() {
		return rmn;
	}
	public void setRmn(int rmn) {
		this.rmn = rmn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

	
}
