package com.job.usecases;

import java.util.List;
import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.ProjectsBeen;

public class ListOfProjects {

	public static void ProjectsList() {
		// TODO Auto-generated method stub
		
		BDODao daos = new BDOImp();
		
	try {
		List<ProjectsBeen> dao =daos.ListOfProjects();
		
		for (ProjectsBeen projectsBeen : dao) {
			System.out.println(ConsoleColor.BLUE_ITALIC+ "Project name : " + projectsBeen.getName()+ ConsoleColor.RESET);
			System.out.println(ConsoleColor.BLUE_ITALIC+"Project No : " + projectsBeen.getProectNo()+ ConsoleColor.RESET);
			System.out.println(ConsoleColor.BLUE_ITALIC+"Number of Employee is working : " + projectsBeen.getNoOfEmployee()+ ConsoleColor.RESET);
			System.out.println(ConsoleColor.BLUE_ITALIC+" Our Project locate at : " + projectsBeen.getLocation()+ ConsoleColor.RESET);
			System.out.println(ConsoleColor.BLUE_ITALIC+"Our project total wages : " + projectsBeen.getTotalWages()+ ConsoleColor.RESET);
			System.out.println(ConsoleColor.BLUE_ITALIC+"==================================================="+ ConsoleColor.RESET);
			
		}
		
		
	} catch (BDOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	
	
	}

}
