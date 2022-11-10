package com.job.dao;

import java.util.List;

import com.job.exception.BDOException;
import com.job.modelClass.BDOBenn;
import com.job.modelClass.Employee;
import com.job.modelClass.GPMBenn;
import com.job.modelClass.ProjectsBeen;

public interface BDODao {

	public BDOBenn BDOLogIn(String username, String password) throws BDOException;
	
	public String CreateProject(ProjectsBeen pro) throws BDOException;
	
	public List<ProjectsBeen> ListOfProjects() throws BDOException;
	 public String CreateGramPanchayatMember(GPMBenn gpm) throws BDOException;
	 
	 public List<GPMBenn>ListOfGMP() throws BDOException;
	 
	 
}
