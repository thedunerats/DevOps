package com.revature.model;

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

@Entity

@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private int id;
	
	@Column(name="useremail")
	private String useremail;
	
	@Column(name="userpassword")
	private String userpassword;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userroleid")
	private UserRole userrole;
	
//	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	    @JoinTable(name = "guestlist", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "eventid"), 
//	    inverseJoinColumns = @JoinColumn(name = "eventid", referencedColumnName = "userid"))
//	  private Set<Event> events;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userid, String useremail, String userpassword, UserRole userrole/*, Set<Event> events*/) {
		super();
		this.id = userid;
		this.useremail = useremail;
		this.userpassword = userpassword;
		this.userrole = userrole;
//		this.events = events;
	}

	public int getUserid() {
		return id;
	}

	public void setUserid(int userid) {
		this.id = userid;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public UserRole getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}

//	public Set<Event> getEvents() {
//		return events;
//	}
//
//	public void setEvents(Set<Event> events) {
//		this.events = events;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((useremail == null) ? 0 : useremail.hashCode());
		result = prime * result + id;
		result = prime * result + ((userpassword == null) ? 0 : userpassword.hashCode());
		result = prime * result + ((userrole == null) ? 0 : userrole.hashCode());
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
		User other = (User) obj;
//		if (events == null) {
//			if (other.events != null)
//				return false;
//		} else if (!events.equals(other.events))
//			return false;
		if (useremail == null) {
			if (other.useremail != null)
				return false;
		} else if (!useremail.equals(other.useremail))
			return false;
		if (id != other.id)
			return false;
		if (userpassword == null) {
			if (other.userpassword != null)
				return false;
		} else if (!userpassword.equals(other.userpassword))
			return false;
		if (userrole == null) {
			if (other.userrole != null)
				return false;
		} else if (!userrole.equals(other.userrole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userid=" + id + ", useremail=" + useremail + ", userpassword=" + userpassword + ", userrole="
				+ userrole + "]";
	}

	
}
