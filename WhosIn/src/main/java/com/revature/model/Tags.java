package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity

@Table(name="tags")
public class Tags {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tagid")
	private int tagid;
	
	@Column(name="tagname")
	private String tagname;
	
	@ManyToMany(targetEntity=Event.class,mappedBy="tags")
	private Set<Event> events;

	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tags(int tagid, String tagname) {
		super();
		this.tagid = tagid;
		this.tagname = tagname;
	}

	public int getTagid() {
		return tagid;
	}

	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tagid;
		result = prime * result + ((tagname == null) ? 0 : tagname.hashCode());
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
		Tags other = (Tags) obj;
		if (tagid != other.tagid)
			return false;
		if (tagname == null) {
			if (other.tagname != null)
				return false;
		} else if (!tagname.equals(other.tagname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tags [tagid=" + tagid + ", tagname=" + tagname + "]";
	}
}
