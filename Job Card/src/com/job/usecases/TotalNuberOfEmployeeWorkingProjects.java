package com.job.usecases;

import java.util.Scanner;

import com.job.dao.GPMDao;
import com.job.dao.GPMImp;
import com.job.exception.ProjectException;
import com.job.modelClass.ProjectsBeen;

public class TotalNuberOfEmployeeWorkingProjects {

	public static void NumberOfDayWorkingEmployee() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project ID ...");
		int id = sc.nextInt();
		
		GPMDao dao = new GPMImp();
		
		try {
			ProjectsBeen pro = dao.TotalNumberOfDaysEmployeeWorkedInProject(id);
			System.out.println("In "+pro.getName()+" Project total number of days Employee worked is "
							+pro.getNoOfEmployee()+" days and their total wages is "+
					pro.getTotalWages());
			
			
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
