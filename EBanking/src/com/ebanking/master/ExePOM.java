 package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExePOM 
{
	WebDriver w;
	@BeforeTest
	public void PomOpen() throws InterruptedException
	{
		w= new FirefoxDriver();
		w.manage().window().maximize();
		w.get("http://103.211.39.246/ranford2");



		RanfordHPpom RHP = PageFactory.initElements(w, RanfordHPpom.class);
		RHP.ALogin();
	}
	//Page factory for Role creation
	@Test(priority = 3)
	public void RCr() throws InterruptedException, IOException
	{
		// To get the test data file
		FileInputStream f=new FileInputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\ExcelRole.xlsx");
		//Workbook
		XSSFWorkbook wb=new XSSFWorkbook(f);
		//Sheet
		XSSFSheet ws = wb.getSheet("RData");
		//Row Count
		int Rcount = ws.getLastRowNum();
		System.out.println("The number of rows is: "+Rcount);
		//Multiple iterations-----for loop
		for (int i = 1; i <= Rcount; i++) 
		{
			//Row
			XSSFRow wr = ws.getRow(i);
			//Cell
			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);

			XSSFCell wc2 = wr.createCell(2);
			// Get cell values
			String Rname = wc.getStringCellValue();
			String Rtype = wc1.getStringCellValue();
			AdminHPpom AHP = PageFactory.initElements(w,AdminHPpom.class); 
			AHP.ARole();

			RoleDetailspom RD = PageFactory.initElements(w,RoleDetailspom.class);
			RD.RNrole();

			RoleCreationpom RC = PageFactory.initElements(w,RoleCreationpom.class);
			RC.RCreation(Rname,Rtype);

			wb.close();
			Thread.sleep(3000);
			w.switchTo().alert().accept();
			RD.RHome();
		}
	}
	//Page factory for Branch creation	
	@Test(priority = 1)
	public void BCr() throws InterruptedException, IOException
	{
		FileInputStream f=new FileInputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\ExcelBranch.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("BrData");
		int Rcount = ws.getLastRowNum();
		System.out.println("Number of rows is: "+Rcount);
		for (int i = 1; i <=Rcount; i++) 
		{
			XSSFRow wr = ws.getRow(i);
			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			XSSFCell wc3 = wr.getCell(3);
			XSSFCell wc4 = wr.getCell(4);
			XSSFCell wc5 = wr.getCell(5);
			XSSFCell wc6 = wr.createCell(6);
			String Bname = wc.getStringCellValue();
			String Baddress = wc1.getStringCellValue();
			String Bzipcode = wc2.getStringCellValue();
			String Bcountry = wc3.getStringCellValue();
			String Bstate = wc4.getStringCellValue();
			String Bcity = wc5.getStringCellValue();
			AdminHPpom AHP = PageFactory.initElements(w,AdminHPpom.class); 
			AHP.ABranch();

			BranchDetailspom BD = PageFactory.initElements(w,BranchDetailspom.class);
			BD.BNbranch();

			BranchCreationpom BC = PageFactory.initElements(w,BranchCreationpom.class);
			BC.BCreation(Bname,Baddress,Bzipcode,Bcountry,Bstate,Bcity);

			wb.close();
			Thread.sleep(3000);
			w.switchTo().alert().accept();
			BD.BHome();
		}
	}

	//Page factory for Employee creation	
	@Test(priority=2)
	public void ECr() throws InterruptedException, IOException
	{
		FileInputStream f=new FileInputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\banking\\testdata\\ExcelEmployee.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("EmpData");
		int Rcount = ws.getLastRowNum();
		System.out.println("The number of rows is "+Rcount);
		for (int i = 1; i <=Rcount; i++) 
		{
			XSSFRow wr = ws.getRow(i);
			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			XSSFCell wc3 = wr.getCell(3);
			XSSFCell wc4 = wr.createCell(4);
			String Ename = wc.getStringCellValue();
			String Epwd = wc1.getStringCellValue();
			String Erole = wc2.getStringCellValue();
			String Ebranch = wc3.getStringCellValue();
			AdminHPpom AHP = PageFactory.initElements(w,AdminHPpom.class); 
			AHP.AEmployee();

			EmployeeDetailspom ED = PageFactory.initElements(w,EmployeeDetailspom.class);
			ED.ENemployee();

			EmployeeCreationpom EC = PageFactory.initElements(w,EmployeeCreationpom.class);
			EC.ECreation(Ename,Epwd,Erole,Ebranch);
			wb.close();
			Thread.sleep(3000);
			w.switchTo().alert().accept();
			ED.EHome();
		}
	}
	// Admin Logout
	@Test(priority=4)
	public void AdminLogout()
	{
		AdminHPpom AHP = PageFactory.initElements(w,AdminHPpom.class); 
		AHP.ALogout();
	}
	// Banker Login
	@Test(priority=5)
	public void BankerLogin()
	{
		RanfordHPpom RHP = PageFactory.initElements(w, RanfordHPpom.class);
		RHP.BLogin();
	}
	// Closing the Application
	@AfterTest
	public void PomClose()
	{
		BankerHP BHP = PageFactory.initElements(w,BankerHP.class);
		BHP.BLogout();
		w.close();
	}
} 

