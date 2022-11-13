package com.job.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.BDOBenn;

public class BDOLogInUsecasTesting {

	public static Boolean LoginToBDO() {
	
		try {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColor.BANANA_YELLOW+"Enter Username"+ConsoleColor.RESET);
		String name = sc.nextLine();
		
		System.out.println(ConsoleColor.BANANA_YELLOW+ "Enter Password"+ ConsoleColor.RESET);
		String password = sc.next();
		
		
		
		BDODao dao = new BDOImp();
		
		try {
			
		BDOBenn bdo = dao.BDOLogIn(name, password);
			
			System.out.println(ConsoleColor.GREEN_BACKGROUND+ "Login Successfully "+ bdo.getUsername()+ ConsoleColor.FOREST_GREEN);;
			return true;
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(ConsoleColor.RED_BACKGROUND+ e.getMessage()+ConsoleColor.RESET);
			return false;
		}

	}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColor.RED_BACKGROUND + "Invalid input" + ConsoleColor.RESET);
			return false;
		}
	}

}
