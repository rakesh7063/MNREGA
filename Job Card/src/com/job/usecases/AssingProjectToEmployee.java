package com.job.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.GPMDao;
import com.job.dao.GPMImp;
import com.job.exception.EmployeeException;
import com.job.exception.ProjectException;
import com.job.modelClass.ProjectsBeen;

public class AssingProjectToEmployee {

	public static void ProjectAssingEmployee(){
		try {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(ConsoleColor.ORANGE +"Enter Employee Id "+ ConsoleColor.RESET);
		int emid = sc.nextInt();
		
		System.out.println(ConsoleColor.ORANGE+ "Enter Project No.."+ ConsoleColor.RESET);
		int prono = sc.nextInt();
		
		GPMDao dao = new GPMImp();
		
		
		try {
			ProjectsBeen pro =	dao.EmployeeAllocateProject(emid, prono);
			System.out.println(ConsoleColor.GREEN_BRIGHT+ " Employee Id "+emid+ " assign to project "+pro.getName()+ ConsoleColor.RESET);
			
		} catch (EmployeeException e) {
			
			System.out.println(ConsoleColor.RED+ e.getMessage() + ConsoleColor.RESET);
			
			e.printStackTrace();
		} catch (ProjectException e) {

			e.printStackTrace();
			System.out.println(ConsoleColor.RED_BACKGROUND +e.getMessage()+ ConsoleColor.RESET);
		}

	}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColor.RED_BACKGROUND + "Invalid input" + ConsoleColor.RESET);
		}
	}

}
