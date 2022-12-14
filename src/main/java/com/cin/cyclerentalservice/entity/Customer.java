package com.cin.cyclerentalservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
	@NamedQuery(name = "findAll.customer", query = "select c from Customer as c where status_cd = 'ACTIVE'")
})
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID", nullable=false, unique=true)
	private int customerId;
	
	@Column(name = "FIRST_NM", nullable=false, length=100)
	private String firstName;
	
	@Column(name = "MIDDLE_NM", length=100)
	private String middleName;
	
	@Column(name = "LAST_NM", nullable=false, length=100)
	private String lastName;
	
	@Column(name = "STATUS_CD", nullable=false, length=50)
	private String statusCode;
	
	@Column(name = "ADDRESS_LINE1", nullable=false, length=400)
	private String addressLine1;
	
	@Column(name = "ADDRESS_LINE2", length=400)
	private String addressLine2;
	
	@Column(name = "CITY", nullable=false, length=100)
	private String city;
	
	@Column(name = "STATE", nullable=false, length=100)
	private String state;
	
	@Column(name = "COUNTRY", nullable=false, length=100)
	private String country;
	
	@Column(name = "POSTAL_CD", nullable=false, length=50)
	private String postalCode;
	
	public Customer() {
	
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
