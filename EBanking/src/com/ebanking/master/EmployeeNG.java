package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeNG extends Base
{
	@Test(dataProvider = "Edata")
	public void Emp(String ename,String epwd,String erole,String ebranch) throws InterruptedException
	{
		l.EmpCreation(ename, epwd, erole, ebranch);
	}
	@DataProvider
	public Object[][] Edata()
	{
		Object[][] obj=new Object[3][4];
		obj[0][0]="JamieGibbons";
		obj[0][1]="Moss435";
		obj[0][2]="banker";
		obj[0][3]="DutchBank";
		
		obj[1][0]="SaraMcNeal";
		obj[1][1]="Salt2356";
		obj[1][2]="Accountant";
		obj[1][3]="abcdef";
		
		obj[2][0]="SeemaRoy";
		obj[2][1]="page567";
		obj[2][2]="Manager";
		obj[2][3]="Akronbranch";
		
		return obj;
	
		
	}
}
