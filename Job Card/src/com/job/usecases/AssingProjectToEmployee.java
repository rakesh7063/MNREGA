package com.job.usecases;

import java.util.Scanner;

import com.job.dao.GPMDao;
import com.job.dao.GPMImp;
import com.job.exception.EmployeeException;
import com.job.exception.ProjectException;
import com.job.modelClass.ProjectsBeen;

public class AssingProjectToEmployee {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id ");
		int emid = sc.nextInt();
		
		System.out.println("Enter Project No..");
		int prono = sc.nextInt();
		
		GPMDao dao = new GPMImp();
		
		
		try {
			ProjectsBeen pro =	dao.EmployeeAllocateProject(emid, prono);
			System.out.println(" Employee Id "+emid+ " assign to project "+pro.getName());
			
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
			
			e.printStackTrace();
		} catch (ProjectException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
