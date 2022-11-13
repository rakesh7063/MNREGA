package com.job.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.ProjectException;
import com.job.modelClass.Employee;

public class ListOfEmployeeOnThatProjects {

	public static void HowManyEmployeeWorkingProjects() {
		
		
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println(ConsoleColor.ORANGE +"Enter Project Id .."+ ConsoleColor.RESET);
		int id = sc.nextInt();
		
		BDODao dao = new BDOImp();
		
		try {
			Employee emp = dao.ListOfEmployeeWorkingOnThatProject(id);
			System.out.println(ConsoleColor.PURPLE+ "In "+emp.getProject().getName()+
					" Project number of Employee working = "
			+emp.getNo_of_days()+" and their totalwages = "+ emp.getWages()
			+ ConsoleColor.RESET);
			
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(ConsoleColor.RED+e.getMessage()+ ConsoleColor.RESET);
		}
		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColor.RED_BACKGROUND + "Invalid input" + ConsoleColor.RESET);
		}
	}
		

}
