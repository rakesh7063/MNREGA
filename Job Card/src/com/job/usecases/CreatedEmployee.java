package com.job.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.GPMDao;
import com.job.dao.GPMImp;
import com.job.exception.GPMException;
import com.job.modelClass.Employee;

public class CreatedEmployee {

	public static void AddEmployeeUserCase() {


		Scanner sc= new Scanner(System.in);
		try {
		System.out.println(ConsoleColor.ORANGE+ "Enter Employee Name"+ConsoleColor.RESET );
		String empname = sc.next();
		
		System.out.println(ConsoleColor.ORANGE+ "Enter Employee Gender"+ ConsoleColor.RESET);
		String empgender = sc.next();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Employee Address"+ ConsoleColor.RESET);
		
		String empAddress = sc.next();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Employee Contact Number"+ConsoleColor.RESET);
		String empPhone = sc.next();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Employee Duty_Days"+ ConsoleColor.RESET);
		
		int empduty = sc.nextInt();
		
		System.out.println(ConsoleColor.ORANGE +"Enter Wages per day "+ ConsoleColor.RESET);
		
		int empWages = sc.nextInt();
		Employee emp = new Employee(empname, empgender, empAddress, empPhone, empduty, empWages);
		
		GPMDao dao = new GPMImp();
		try {
			String result = dao.CreatedEmployee(emp);
			System.out.println(ConsoleColor.GREEN_ITALIC+ result+ ConsoleColor.RESET);
			
		} catch (GPMException e) {
			
			System.out.println(ConsoleColor.RED_ITALIC+ e.getMessage()+ ConsoleColor.RESET);
		}

		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColor.RED_BACKGROUND + "Invalid input" + ConsoleColor.RESET);
		}
	}

}
