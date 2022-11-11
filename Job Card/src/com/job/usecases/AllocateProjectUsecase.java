package com.job.usecases;

import java.util.Scanner;

import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.GPMException;
import com.job.exception.ProjectException;
import com.job.modelClass.ProjectsBeen;

public class AllocateProjectUsecase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Gram Panchayite name ");
		String name = sc.next();
		
		System.out.println("Enter Project No ...");
		int projectId = sc.nextInt();
		
		BDODao dao = new BDOImp();
	 try {
		ProjectsBeen pro =	dao.AllocateProjectUnderGmp(name, projectId);
		
		System.out.println(name+ " Project allocte to "+ pro.getName());
	} catch (ProjectException e) {
		
		e.printStackTrace();
		
		System.out.println(e.getMessage());
	} catch (GPMException e) {
		
		e.printStackTrace();
		
		System.out.println(e.getMessage());
	}
		
	}

}
