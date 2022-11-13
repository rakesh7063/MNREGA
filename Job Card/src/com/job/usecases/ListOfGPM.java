package com.job.usecases;

import java.util.List;

import com.job.CustomColor.ConsoleColor;
import com.job.dao.BDODao;
import com.job.dao.BDOImp;
import com.job.exception.BDOException;
import com.job.modelClass.GPMBenn;

public class ListOfGPM {

	public static void GPMList() {
		// TODO Auto-generated method stub
		
		BDODao daos =new BDOImp();

	try {
		List<GPMBenn> dao =	daos.ListOfGMP();
		for (GPMBenn gpm : dao) {
			System.out.println(ConsoleColor.GREEN_BOLD_BRIGHT+"Gram Panchayat Member Id "+ gpm.getId()
			+"\n"+
					"Gram Panchayat Member Name "+gpm.getName()+"\n"+
			"Gram Panchayat Member Location "+gpm.getLocation()+"\n"+
					"Gram Panchayat Member Phone Number "+gpm.getPhoneNo()+
					ConsoleColor.FOREST_GREEN);
		}
		
	} catch (BDOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		System.out.println(e.getMessage());
	}
		
	}

}
