package com.revature.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="eventid")
	private int id;
	
	@Column(name="eventname")
	private String eventname;
	
	@Column(name="eventdescription")
	private String eventdescription;
	
	@Column(name="eventstartdate")
	private Timestamp eventstartdate;
	
	@Column(name="eventenddate")
	private Timestamp eventenddate;
	
	@Column(name="latitude")
	private Double latitude;
	
	@Column(name="longitude")
	private Double longitude;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="eventowner")
	private User eventowner;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "eventtags",
    joinColumns = {@JoinColumn(name = "eventid")}, 
    inverseJoinColumns = {@JoinColumn(name = "tagid")})
	@JsonIgnore
	private Set<Tags> tags = new HashSet<>();
	

	public Event() {
		super();
	}

	public Event(int id, String eventname, String eventdescription, Timestamp eventstartdate, Timestamp eventenddate,
			Double latitude, Double longitude, User eventowner, Set<Tags> tags) {
		super();
		this.id = id;
		this.eventname = eventname;
		this.eventdescription = eventdescription;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.eventowner = eventowner;
		this.tags = tags;
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

	public Timestamp getEventstartdate() {
		return eventstartdate;
	}

	public void setEventstartdate(Timestamp eventstartdate) {
		this.eventstartdate = eventstartdate;
	}

	public Timestamp getEventenddate() {
		return eventenddate;
	}

	public void setEventenddate(Timestamp eventenddate) {
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

	public User getEventowner() {
		return eventowner;
	}

	public void setEventowner(User eventowner) {
		this.eventowner = eventowner;
	}

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventdescription == null) ? 0 : eventdescription.hashCode());
		result = prime * result + ((eventenddate == null) ? 0 : eventenddate.hashCode());
		result = prime * result + ((eventname == null) ? 0 : eventname.hashCode());
		result = prime * result + ((eventstartdate == null) ? 0 : eventstartdate.hashCode());
		result = prime * result + id;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((eventowner == null) ? 0 : eventowner.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		Event other = (Event) obj;
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
		if (eventowner == null) {
			if (other.eventowner != null)
				return false;
		} else if (!eventowner.equals(other.eventowner))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventname=" + eventname + ", eventdescription=" + eventdescription
				+ ", eventstartdate=" + eventstartdate + ", eventenddate=" + eventenddate + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", eventowner=" + eventowner + ", tags=" + tags + "]";
	}
	
}
