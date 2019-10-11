package com.revature.model;

public class GuestRequestModel {
	private int eventid;
	private int userid;
	public GuestRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GuestRequestModel(int eventid, int userid) {
		super();
		this.eventid = eventid;
		this.userid = userid;
	}
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventid;
		result = prime * result + userid;
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
		GuestRequestModel other = (GuestRequestModel) obj;
		if (eventid != other.eventid)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GuestRequestModel [eventid=" + eventid + ", userid=" + userid + "]";
	}
	
	
	
}
