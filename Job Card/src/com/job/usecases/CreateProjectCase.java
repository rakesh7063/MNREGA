package com.job.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.ProjectsBeen;

public class CreateProjectCase {

	public static void AddProjects() {
		
		Scanner sc= new Scanner(System.in);
		try {
		System.out.println(ConsoleColor.ORANGE + "Enter Project Name" + ConsoleColor.RESET);
		String projectname = sc.next();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Project Number"+ ConsoleColor.RESET);
		
		int pnumber = sc.nextInt();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Total Employee Working On Project"+ ConsoleColor.RESET);
		int totalEmployee = sc.nextInt();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Total Wages of Project"+ ConsoleColor.RESET);
		
		int totalWages = sc.nextInt();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Project Location"+ ConsoleColor.RESET);
		
		String plocation = sc.next();
		
		BDODao dao = new BDOImp();
		
		ProjectsBeen project = new ProjectsBeen(projectname, totalEmployee, totalWages, plocation,pnumber );
		
		try {
			String res = dao.CreateProject(project);
			System.out.println(ConsoleColor.GREEN_BOLD + res + ConsoleColor.RESET);
		} catch (BDOException e) {
			
			
			System.out.println(ConsoleColor.RED_BACKGROUND + e.getMessage()+ ConsoleColor.RESET);
		}
		
		}
		catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println(ConsoleColor.RED_BACKGROUND + "Invalid input" + ConsoleColor.RESET);
		}

		
		
		
	}

}
