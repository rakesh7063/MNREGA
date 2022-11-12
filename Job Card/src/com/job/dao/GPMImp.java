package com.job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.job.exception.EmployeeException;
import com.job.exception.GPMException;
import com.job.exception.ProjectException;
import com.job.modelClass.Employee;
import com.job.modelClass.GPMBenn;
import com.job.modelClass.ProjectsBeen;
import com.job.utility.DBUtility;


public class GPMImp implements GPMDao {

	@Override
	public GPMBenn LoginGPM(String username, String password) throws GPMException {
		GPMBenn gpm = null;
		
		try (Connection conn = DBUtility.ProvideConnetion()) {
			
			PreparedStatement ps = conn.prepareStatement("select gname from gpm where username=? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
			String name =	rs.getString("gname");
				gpm = new GPMBenn();
				gpm.setName(name);
				
			}
			else {
				throw new GPMException("Invaid password or username");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new GPMException(e.getMessage());
			
			
		}
		
		
		
		
		return gpm;
	}

	@Override
	public String CreatedEmployee(Employee employee) throws GPMException {
		String result = "Not inserted";
		
		try (Connection conn = DBUtility.ProvideConnetion()) {
			
		PreparedStatement ps =	conn.prepareStatement("insert into Employee (ename,egender, eaddress,ephone,no_duty_day,wages)"
					                                                           +"values(?,?,?,?,?,?)");
			
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getGender());
			ps.setString(3, employee.getAddress());
			ps.setString(4, employee.getPhoneNo());
			ps.setInt(5, employee.getNo_of_days());
			int total = employee.getNo_of_days()*employee.getWages();
			ps.setInt(6,total );
			
			int x = ps.executeUpdate();
			if(x>0) {
				result = "Employee create sucsessfuly...";
			}
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
			throw new GPMException(e.getMessage());

			
			
		}
		return result;
		
	}

	@Override
	public ProjectsBeen EmployeeAllocateProject(int emId, int ProjId) throws EmployeeException, ProjectException {
		ProjectsBeen pro = null;
		
try (Connection conn = DBUtility.ProvideConnetion()) {
			
			PreparedStatement ps = conn.prepareStatement("select eid from employee where eid = ?");
			
			ps.setInt(1, emId);
			
			ResultSet rs1 = ps.executeQuery();
			
			if(rs1.next()) {
			PreparedStatement ps2=conn.prepareStatement("select projectNo,pname from projects where projectNo = ?");
			
			ps2.setInt(1, ProjId);
			
			ResultSet rs2 = ps2.executeQuery();
			
			if(rs2.next()) {
				String ProName = rs2.getString("pname");
				
			PreparedStatement ps3 = conn.prepareStatement("update employee set projAssigned =? where eid = ?");
			
			ps3.setInt(1, ProjId);
			ps3.setInt(2, emId);
			
		 	int x = ps3.executeUpdate();
		 	if(x>0) {
		 		pro = new ProjectsBeen();
		 		pro.setName(ProName);
		 		
		 	}
		 	else {
		 		throw new ProjectException("Technical eror......");
		 	}
				
				
			}
			else {
				throw new ProjectException("Invalid Project id....");
			}
				
				
			}
			else {
				throw new EmployeeException("Employee is not found "+emId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		
		return pro;
	}

	@Override
	public Employee ViewDetailsEmployee(int emid) throws EmployeeException {
		Employee emp = null;
		
		try (Connection conn = DBUtility.ProvideConnetion()) {
			
		PreparedStatement ps =	conn.prepareStatement("select * from employee where eid = ?");
		ps.setInt(1, emid);
		
		ResultSet rs1 = ps.executeQuery();
		
		if(rs1.next()) {
			int empid = rs1.getInt("eid");
			String ename =rs1.getString("ename");
			String gender = rs1.getString("egender");
			String address = rs1.getString("eaddress");
			String phone = rs1.getString("ephone");
			int douty = rs1.getInt("no_duty_day");
			int proId = rs1.getInt("projAssigned");
			int wages = rs1.getInt("wages");
			
			emp = new Employee();
			emp.setName(ename);
			emp.setGender(gender);
			emp.setAddress(address);
			emp.setId(empid);
			emp.setPhoneNo(phone);
			emp.setWages(wages);
			emp.setNo_of_days(douty);
//			if(proId>0) {
//			
//			PreparedStatement ps2 = conn.prepareStatement("select pname from projects where projectNo = ?");
//			
//			ps2.setInt(1, proId);
//			
//			ResultSet rs2 = ps2.executeQuery();
//			
//			if(rs2.next()) {
//				
//				String ProName = rs2.getString("pname");
//				
//				
//				ProjectsBeen pro = new ProjectsBeen();
//				pro.setName(ProName);
//				
//				
//				
//				System.out.println(ProName);
//				
//			}
//			
//			}
			
			
			
		}
		else {
			throw new EmployeeException("Invalid Employee Id"+ emid);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		return emp;
		
	}

	@Override
	public String UpdatePassworToGPM(String username, String password) throws GPMException {
		
		String res = "Not updated";
		
		try (Connection conn = DBUtility.ProvideConnetion()) {
			
			PreparedStatement ps = conn.prepareStatement("update gpm set password= ? where username= ?");
			ps.setString(1,password);
			ps.setString(2, username);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				res = "Password Update Sucssesfuly.....";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new GPMException(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		return res;
	}

	@Override
	public ProjectsBeen TotalNumberOfDaysEmployeeWorkedInProject(int projectId) throws ProjectException {
		
		ProjectsBeen project = null;
		
		try (Connection conn = DBUtility.ProvideConnetion()) {
			
			PreparedStatement ps1 = conn.prepareStatement("select pname from projects where projectno = ?");
			
			ps1.setInt(1, projectId);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
			PreparedStatement ps2 =conn.prepareCall("select sum(no_duty_day)totaldays ,sum(wages)totalwages,p.pname  from employee e INNER JOIN Projects p ON e.projAssigned = p.projectNO where p.projectNo=?");
				ps2.setInt(1, projectId);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					int days = rs2.getInt("totaldays");
					int wages = rs2.getInt("totalwages");
					String name = rs2.getString("pname");
					
					project = new ProjectsBeen();
					project.setNoOfEmployee(days);
					project.setTotalWages(wages);
					project.setName(name);
				}
				
				
			}
			else
				throw new ProjectException("Invaid Project Id ");
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		return project;
		
	}
	
	

}
