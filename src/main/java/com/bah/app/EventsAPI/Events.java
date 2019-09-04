package com.bah.app.EventsAPI;

import java.sql.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Events")
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "DESCRIPTION")
	private String eventDescription;
	@Column(name = "EVENT_CODE")
	private String eventCode;
	@Column(name = "TITLE")
	private String title;
	


	public Events() {
		// TODO Auto-generated constructor stub
	}


	public Events(String eventDescription, String eventCode, String title) {
		super();
		Random random = new Random();
		this.id = random.nextLong();
		this.eventDescription = eventDescription;
		this.eventCode = eventCode;
		this.title = title;
	}


	public String getEventDescription() {
		return eventDescription;
	}


	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}


	public String getEventCode() {
		return eventCode;
	}


	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public long getId() {
		return this.id;
	}
}
