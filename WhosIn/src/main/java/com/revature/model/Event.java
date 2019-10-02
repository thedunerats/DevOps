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
import javax.persistence.Table;

@Entity

@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="eventid")
	private int eventid;
	
	@Column(name="eventname")
	private String eventname;
	
	@Column(name="eventdescription")
	private String eventdescription;
	
	@Column(name="eventstartdate")
	private Timestamp eventstartdate;
	
	@Column(name="eventenddate")
	private Timestamp eventenddate;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;
	
	@JoinColumn(name="owner")
	private User owner;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "eventtags", joinColumns = @JoinColumn(name = "eventid", referencedColumnName = "tagid"), 
    inverseJoinColumns = @JoinColumn(name = "tagid", referencedColumnName = "eventid"))
	private Set<Tags> tags;
	
	@ManyToMany(targetEntity=Event.class,mappedBy="events")
	private Set<User> users;

	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", eventname=" + eventname + ", eventdescription=" + eventdescription
				+ ", eventstartdate=" + eventstartdate + ", eventenddate=" + eventenddate + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", owner=" + owner + ", tags=" + tags + ", users=" + users + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventdescription == null) ? 0 : eventdescription.hashCode());
		result = prime * result + ((eventenddate == null) ? 0 : eventenddate.hashCode());
		result = prime * result + eventid;
		result = prime * result + ((eventname == null) ? 0 : eventname.hashCode());
		result = prime * result + ((eventstartdate == null) ? 0 : eventstartdate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (eventid != other.eventid)
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
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Event(int eventid, String eventname, String eventdescription, Timestamp eventstartdate,
			Timestamp eventenddate, double latitude, double longitude, User owner, Set<Tags> tags, Set<User> users) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.eventdescription = eventdescription;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.owner = owner;
		this.tags = tags;
		this.users = users;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
}
