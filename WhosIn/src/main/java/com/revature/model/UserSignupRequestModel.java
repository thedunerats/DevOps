package com.revature.model;

public class UserSignupRequestModel {
		private int id;
		private String username;
		private String password;
		private int userroleid;
		
		
		public UserSignupRequestModel(int id, String username, String password, int userRoleId) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.userroleid = userRoleId;
		}
		public UserSignupRequestModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getUserRoleId() {
			return userroleid;
		}
		public void setUserRoleId(int userRoleId) {
			this.userroleid = userRoleId;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
	}
