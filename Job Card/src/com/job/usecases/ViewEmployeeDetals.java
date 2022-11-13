package com.job.usecases;

import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.GPMDao;
import com.job.dao.GPMImp;
import com.job.exception.EmployeeException;
import com.job.modelClass.Employee;

public class ViewEmployeeDetals {

	public static void DetailsOfEmployee() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID ");
		int id = sc.nextInt();
		
		GPMDao dao = new GPMImp();
		try {
			Employee emp = dao.ViewDetailsEmployee(id);
			System.out.println(ConsoleColor.YELLOW + "Employee ID "+emp.getId()
			                   +"\n"+ "Employee Name "+emp.getName()+"\n"+
					              "Employee Gender "+emp.getGender() +"\n"+
					              "Employee Address "+emp.getAddress()+"\n"+
			                     "Employee Phone No. "+ emp.getPhoneNo()+"\n"+
					              "Employee Working day "+emp.getNo_of_days()+"\n"+
					              "Employee Wages "+emp.getWages()+ ConsoleColor.RESET);
			
			try {
				System.out.println(ConsoleColor.YELLOW + "Employee Assing to Project "+emp.getProject().getName() + ConsoleColor.RESET);
			} catch (NullPointerException e) {
				// TODO: handle exception
				System.out.println(ConsoleColor.RED_STRIKE +"Employee Not Working Any Projects" + ConsoleColor.RESET);
			}
//			if(emp.getProject().getName() != null ) {
//				
//				System.out.println( "Employee Assing to Project "+emp.getProject().getName());
//			}
//			else {
//				System.out.println("Employee Not Working Any Projects");
//			}
			
		} catch (EmployeeException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
