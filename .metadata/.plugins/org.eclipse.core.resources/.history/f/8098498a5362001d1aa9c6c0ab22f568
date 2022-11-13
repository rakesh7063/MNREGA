package com.job.usecases;

import java.util.Scanner;

import com.job.dao.GPMDao;
import com.job.dao.GPMImp;
import com.job.exception.GPMException;

public class UpdatePassworUsecase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username..");
		String username = sc.next();
		System.out.println("Enter New  Password ...");
		String password = sc.next();
		
		GPMDao dao = new GPMImp();
		try {
			String res = dao.UpdatePassworToGPM(username, password);
			System.out.println(res);

		} catch (GPMException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
		

		
	}

}
