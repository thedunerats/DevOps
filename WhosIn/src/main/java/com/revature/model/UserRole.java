package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userrole")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userroleid")
	private int id;
	
	@Column
	private String userrole;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(int userroleid, String userrole) {
		super();
		this.id = userroleid;
		this.userrole = userrole;
	}

	public int getUserroleid() {
		return id;
	}

	public void setUserroleid(int userroleid) {
		this.id = userroleid;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userrole == null) ? 0 : userrole.hashCode());
		result = prime * result + id;
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
		UserRole other = (UserRole) obj;
		if (userrole == null) {
			if (other.userrole != null)
				return false;
		} else if (!userrole.equals(other.userrole))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRoles [userroleid=" + id + ", userrole=" + userrole + "]";
	}
	
	
}
