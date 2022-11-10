package com.job.usecases;

import java.util.List;
import java.util.Scanner;

import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.ProjectsBeen;

public class ListOfProjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BDODao daos = new BDOImp();
		
	try {
		List<ProjectsBeen> dao =daos.ListOfProjects();
		
		for (ProjectsBeen projectsBeen : dao) {
			System.out.println("Project name : " + projectsBeen.getName());
			System.out.println("Project No : " + projectsBeen.getProectNo());
			System.out.println("Number of Employee is working : " + projectsBeen.getNoOfEmployee());
			System.out.println(" Our Project locate at : " + projectsBeen.getLocation());
			System.out.println("Our project total wages : " + projectsBeen.getTotalWages());
			System.out.println("===================================================");
			
		}
		
		
	} catch (BDOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	
	
	}

}
