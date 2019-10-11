package com.revature.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventRequestModel {
	private int id;
	
	private String eventName;
	
	private String eventDescription;
	
	private String eventStartDate;
	
	private String eventEndDate;
	
	private Double latitude;
	
	private Double longitude;
	
	private int eventOwner;
	
	public EventRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public EventRequestModel(int id, String eventName, String eventDescription, String eventStartDate,
			String eventEndDate, Double latitude, Double longitude, int eventOwner) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.eventOwner = eventOwner;
	}



	public Timestamp convertStringToTimestamp(String s) {
	    Date parsedTimeStamp;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
			parsedTimeStamp = dateFormat.parse(s+":000");
			return new Timestamp(parsedTimeStamp.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEventName() {
		return eventName;
	}



	public void setEventName(String eventName) {
		this.eventName = eventName;
	}



	public String getEventDescription() {
		return eventDescription;
	}



	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}



	public String getEventStartDate() {
		return eventStartDate;
	}



	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}



	public String getEventEndDate() {
		return eventEndDate;
	}



	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}



	public Double getLatitude() {
		return latitude;
	}



	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}



	public Double getLongitude() {
		return longitude;
	}



	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}



	public int getEventOwner() {
		return eventOwner;
	}



	public void setEventOwner(int eventOwner) {
		this.eventOwner = eventOwner;
	}



	@Override
	public String toString() {
		return "EventRequestModel [id=" + id + ", eventname=" + eventName + ", eventdescription=" + eventDescription
				+ ", eventstartdate=" + eventStartDate + ", eventenddate=" + eventEndDate + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", eventownerid=" + eventOwner + "]";
	}

	
}
