package com.job.usecases;

import java.util.Scanner;

import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.BDOBenn;

public class BDOLogInUsecasTesting {

	public static void main(String[] args) {
	
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String name = sc.nextLine();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		
		
		BDODao dao = new BDOImp();
		
		try {
			
		BDOBenn bdo = dao.BDOLogIn(name, password);
			
			System.out.println("Welcome to B.D.O "+ bdo.getUsername());
			
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
