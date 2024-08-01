package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchNG extends Base
{
	@Test(dataProvider = "Bdata")
	public void Br(String Bname,String Badd,String Bzip,String Bctry,String Bstate,String Bcity) throws InterruptedException 
	{
		l.BrCreation(Bname, Badd, Bzip, Bctry, Bstate, Bcity);
	}
	@DataProvider
	public Object[][] Bdata()
	{
		Object[][] obj=new Object[3][6];
		obj[0][0]="DC431Alfa";
		obj[0][1]="BradfordRd";
		obj[0][2]="32714";
		obj[0][3]="USA";
		obj[0][4]="Washington";
		obj[0][5]="Olympia";
		
		obj[1][0]="MH567Beta";
		obj[1][1]="NagpurRoad";
		obj[1][2]="56789";
		obj[1][3]="INDIA";
		obj[1][4]="MAHARASTRA";
		obj[1][5]="SHIRDI";
		

		obj[2][0]="TN234Theeta";
		obj[2][1]="MGRRoad";
		obj[2][2]="23567";
		obj[2][3]="INDIA";
		obj[2][4]="Tamil Nadu";
		obj[2][5]="MADHURAI";
		
		return obj;
		
	}
}
