package com.job.usecases;

import java.util.Scanner;

import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.GPMBenn;

public class GPMCratedByBDO {

	public static void GPMAddByBDO() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Gram pranchayit member name ");
		String name = sc.next();
		
		System.out.println("Enter Gram Pranchayit Member Adderss");
		String location = sc.next();
		
		System.out.println("Enter Gram Pranchayit Member Phone Number");
		String phone = sc.next();
		
		System.out.println("Enter Gram Pranchayit Username ");
		String user = sc.next();
		
		System.out.println("Enter Gram Pranchayit Password ");
		String password = sc.next();
		
		
		GPMBenn gpm = new GPMBenn(name, user, password, location, phone);
		
		BDODao dao = new BDOImp();
		
		try {
			String res = dao.CreateGramPanchayatMember(gpm);
			System.out.println(res);
			
		} catch (BDOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		

	}

}
