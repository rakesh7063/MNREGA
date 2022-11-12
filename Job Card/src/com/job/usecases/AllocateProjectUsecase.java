package com.job.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.GPMException;
import com.job.exception.ProjectException;
import com.job.modelClass.ProjectsBeen;

public class AllocateProjectUsecase {

	public static void ProjectAllocateToGPM() {
		

		Scanner sc = new Scanner(System.in);
		try {
		System.out.println(ConsoleColor.ORANGE+ "Enter Gram Panchayite name " + ConsoleColor.RESET);
		String name = sc.next();
		
		System.out.println(ConsoleColor.ORANGE+ "Enter Project No ..."+ ConsoleColor.RESET);
		int projectId = sc.nextInt();
		
		BDODao dao = new BDOImp();
	 try {
		ProjectsBeen pro =	dao.AllocateProjectUnderGmp(name, projectId);
		
		System.out.println(ConsoleColor.GREEN_BACKGROUND + name+ " Project allocte to "+ pro.getName() +ConsoleColor.RESET );
	} catch (ProjectException e) {
		
		e.printStackTrace();
		
		System.out.println(e.getMessage());
	} catch (GPMException e) {
		
		e.printStackTrace();
		
		System.out.println(ConsoleColor.RED_BACKGROUND + e.getMessage()+ ConsoleColor.RESET);
	}
		
	}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColor.RED_BACKGROUND + "Invalid input" + ConsoleColor.RESET);
		}

}
