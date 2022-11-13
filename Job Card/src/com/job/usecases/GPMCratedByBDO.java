package com.job.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.GPMBenn;

public class GPMCratedByBDO {

	public static void GPMAddByBDO() {
		
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println(ConsoleColor.ORANGE +"Enter Gram pranchayit member name "+ ConsoleColor.RESET);
		String name = sc.next();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Gram Pranchayit Member Adderss"+ ConsoleColor.RESET);
		String location = sc.next();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Gram Pranchayit Member Phone Number"+ ConsoleColor.RESET);
		String phone = sc.next();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Gram Pranchayit Username "+ ConsoleColor.RESET);
		String user = sc.next();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Gram Pranchayit Password "+ ConsoleColor.RESET);
		String password = sc.next();
		
		
		GPMBenn gpm = new GPMBenn(name, user, password, location, phone);
		
		BDODao dao = new BDOImp();
		
		try {
			String res = dao.CreateGramPanchayatMember(gpm);
			System.out.println(ConsoleColor.GREEN_BACKGROUND_BRIGHT+ res+ ConsoleColor.RESET);
			
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(ConsoleColor.RED_BACKGROUND+ e.getMessage()+ ConsoleColor.RESET);
		}
		
		}
		catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println(ConsoleColor.RED_BACKGROUND + "Invalid input" + ConsoleColor.RESET);
		}

	}

}
