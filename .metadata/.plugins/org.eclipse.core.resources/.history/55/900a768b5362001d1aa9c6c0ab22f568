package com.job.usecases;

import java.util.Scanner;

import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.ProjectException;
import com.job.modelClass.Employee;

public class ListOfEmployeeOnThatProjects {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project Id ..");
		int id = sc.nextInt();
		
		BDODao dao = new BDOImp();
		
		try {
			Employee emp = dao.ListOfEmployeeWorkingOnThatProject(id);
			System.out.println("In "+emp.getProject().getName()+" Project number of Employee working = "+emp.getNo_of_days()+" and their totalwages = "+ emp.getWages());
			
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
