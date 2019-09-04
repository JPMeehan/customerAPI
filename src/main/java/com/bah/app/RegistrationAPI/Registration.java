package com.bah.app.RegistrationAPI;

import java.sql.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Registration")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "EVENT_ID")
	private Long eventID;
	@Column(name = "CUSTOMER_ID")
	private Long customerID;
	@Column(name = "Registration_Date")
	private Date registrationDate;
	@Column(name = "Notes")
	private String notes;

	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(Long eventID, Long customerID, Date registrationDate, String notes) {
		super();
		this.eventID = eventID;
		this.customerID = customerID;
		this.registrationDate = registrationDate;
		this.notes = notes;
		Random random = new Random();
		this.id = random.nextLong();
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}
}
