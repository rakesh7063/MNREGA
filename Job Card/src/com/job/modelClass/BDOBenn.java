package com.job.modelClass;

public class BDOBenn {

	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public BDOBenn() {
		// TODO Auto-generated constructor stub
	}
	public BDOBenn(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "BDOBenn [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
