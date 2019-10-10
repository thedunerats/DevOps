package com.revature.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventRequestModel {
	private int id;
	
	private String eventname;
	
	private String eventdescription;
	
	private String eventstartdate;
	
	private String eventenddate;
	
	private Double latitude;
	
	private Double longitude;
	
	private int eventownerid;
	
	public EventRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventRequestModel(int id, String eventname, String eventdescription, String eventstartdate,
			String eventenddate, Double latitude, Double longitude, int eventownerid) {
		super();
		this.id = id;
		this.eventname = eventname;
		this.eventdescription = eventdescription;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.eventownerid = eventownerid;
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

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventdescription() {
		return eventdescription;
	}

	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
	}

	public String getEventstartdate() {
		return eventstartdate;
	}

	public void setEventstartdate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}

	public String getEventenddate() {
		return eventenddate;
	}

	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
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

	public int getEventownerid() {
		return eventownerid;
	}

	public void setEventownerid(int eventownerid) {
		this.eventownerid = eventownerid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventdescription == null) ? 0 : eventdescription.hashCode());
		result = prime * result + ((eventenddate == null) ? 0 : eventenddate.hashCode());
		result = prime * result + ((eventname == null) ? 0 : eventname.hashCode());
		result = prime * result + eventownerid;
		result = prime * result + ((eventstartdate == null) ? 0 : eventstartdate.hashCode());
		result = prime * result + id;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventRequestModel other = (EventRequestModel) obj;
		if (eventdescription == null) {
			if (other.eventdescription != null)
				return false;
		} else if (!eventdescription.equals(other.eventdescription))
			return false;
		if (eventenddate == null) {
			if (other.eventenddate != null)
				return false;
		} else if (!eventenddate.equals(other.eventenddate))
			return false;
		if (eventname == null) {
			if (other.eventname != null)
				return false;
		} else if (!eventname.equals(other.eventname))
			return false;
		if (eventownerid != other.eventownerid)
			return false;
		if (eventstartdate == null) {
			if (other.eventstartdate != null)
				return false;
		} else if (!eventstartdate.equals(other.eventstartdate))
			return false;
		if (id != other.id)
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventRequestModel [id=" + id + ", eventname=" + eventname + ", eventdescription=" + eventdescription
				+ ", eventstartdate=" + eventstartdate + ", eventenddate=" + eventenddate + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", eventownerid=" + eventownerid + "]";
	}

	
}
