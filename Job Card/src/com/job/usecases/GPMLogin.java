package com.job.usecases;

import java.util.Scanner;


import com.job.dao.GPMDao;
import com.job.dao.GPMImp;
import com.job.exception.GPMException;
import com.job.modelClass.GPMBenn;

public class GPMLogin {

	public static void main(String[] args) {
		
    Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String name = sc.nextLine();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		
		
		GPMDao dao = new GPMImp();
		
		try {
			
		GPMBenn gpm = dao.LoginGPM(name, password);
			
			System.out.println("Welcome to Gram Panchayet member "+ gpm.getName());
			
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
