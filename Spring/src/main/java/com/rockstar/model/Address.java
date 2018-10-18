package com.rockstar.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	
	@Id
	private int addressId;
	private String flatNo;
	private String landmark;
	private String location;
	private String building;
	private String district;
	private String city;
	private String state;
	private String country;
	private int pincode;
	
	@JsonIgnore
	@OneToOne(mappedBy="address",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private SubscriberInfo subscriberInfo;
	
	public Address() {
		super();
	}

	
	public Address(int addressId, String flatNo, String landmark, String location, String building, String district,
			String city, String state, String country, int pincode) {
		super();
		this.addressId = addressId;
		this.flatNo = flatNo;
		this.landmark = landmark;
		this.location = location;
		this.building = building;
		this.district = district;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}



	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public SubscriberInfo getSubscriberInfo() {
		return subscriberInfo;
	}

	public void setSubscriberInfo(SubscriberInfo subscriberInfo) {
		this.subscriberInfo = subscriberInfo;
	}

	
	public String getFlatNo() {
		return flatNo;
	}


	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}


	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
}
