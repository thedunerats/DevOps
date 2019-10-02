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
	
	
}
