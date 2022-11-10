package com.job.modelClass;

public class GPMBenn {
	
	private int id;
	private String name;
	private String username;
	private String password;
	private String location;
	private String phoneNo;
	
	
	
	public GPMBenn() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	public GPMBenn(String name, String username, String password, String location, String phoneNo) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.location = location;
		this.phoneNo = phoneNo;
	}



	@Override
	public String toString() {
		return "GPMBenn [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", location=" + location + ", phoneNo=" + phoneNo + "]";
	}
	
	

}
