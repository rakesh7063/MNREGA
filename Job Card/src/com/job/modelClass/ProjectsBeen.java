package com.job.modelClass;

public class ProjectsBeen {

	private String name;
	private int noOfEmployee;
	private String totalWages;
	private String location;
	
	
	private void ProjectBenn() {
		// TODO Auto-generated method stub

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNoOfEmployee() {
		return noOfEmployee;
	}


	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}


	public String getTotalWages() {
		return totalWages;
	}


	public void setTotalWages(String totalWages) {
		this.totalWages = totalWages;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public ProjectsBeen(String name, int noOfEmployee, String totalWages, String location) {
		super();
		this.name = name;
		this.noOfEmployee = noOfEmployee;
		this.totalWages = totalWages;
		this.location = location;
	}


	@Override
	public String toString() {
		return "ProjectsBeen [name=" + name + ", noOfEmployee=" + noOfEmployee + ", totalWages=" + totalWages
				+ ", location=" + location + "]";
	}
	
	
	
}
