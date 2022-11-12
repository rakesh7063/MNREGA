package com.job.usecases;

import java.util.Scanner;

import com.job.dao.GPMDao;
import com.job.dao.GPMImp;
import com.job.exception.GPMException;
import com.job.modelClass.Employee;

public class CreatedEmployee {

	public static void AddEmployeeUserCase() {


		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Employee Name");
		String empname = sc.next();
		
		System.out.println("Enter Employee Gender");
		String empgender = sc.next();
		
		System.out.println("Enter Employee Address");
		
		String empAddress = sc.next();
		
		System.out.println("Enter Employee Contact Number");
		String empPhone = sc.next();
		
		System.out.println("Enter Employee Duty_Days");
		
		int empduty = sc.nextInt();
		
		System.out.println("Enter Wages per day ");
		
		int empWages = sc.nextInt();
		Employee emp = new Employee(empname, empgender, empAddress, empPhone, empduty, empWages);
		
		GPMDao dao = new GPMImp();
		try {
			String result = dao.CreatedEmployee(emp);
			System.out.println(result);
			
		} catch (GPMException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		
	}

}
