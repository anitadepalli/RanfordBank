package com.ebanking.master;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library 
{
	public static WebDriver w;
	public static String ExpVal,ActVal;
	public static FileInputStream f;
	public static Properties p;
	public String LaunchApp(String  url) throws IOException
	{
		f=new FileInputStream("D:\\MindQBankingProject\\EBanking\\src\\com\\ebanking\\properties\\Repo.properties");
		p=new Properties();
		p.load(f);
		w=new FirefoxDriver();
		w.manage().window().maximize();
		String ExpVal = "Ranford Bank";
		w.get(url);
		// Verifying if the right page is displayed
		String ActVal = w.findElement(By.xpath(p.getProperty("LActVal"))).getText();
		if (ExpVal.equalsIgnoreCase(ActVal)) 
		{
			System.out.println("Webpage launch was successful");
		} 
		else 
		{
			System.out.println("Webpage launch was not successful");
		}
		return "Launch Application: Pass";
	}
	public String AdminLogin(String uname,String pwd)
	{
		ExpVal = "Welcome to Admin";
		w.findElement(By.id(p.getProperty("AdminID"))).sendKeys(uname);
		w.findElement(By.id(p.getProperty("Adminpwd"))).sendKeys(pwd);
		w.findElement(By.xpath(p.getProperty("Adminloginbutton"))).click();
		//Verifying if Admin login was successful
		ActVal = w.findElement(By.xpath(p.getProperty("AdminActVal"))).getText();
		if (ExpVal.equalsIgnoreCase(ActVal)) 
		{
			System.out.println("Admin login was successful");
		} 
		else
		{
			System.out.println("Admin login was not successful");
		}
		return "Admin Login: Pass";
	}
	public String BrCreation(String bname,String address,String zipcode,String country,String state,String city) throws InterruptedException
	{
		ExpVal = "Sucessfully";
		w.findElement(By.xpath(p.getProperty("Bbutton"))).click();
		w.findElement(By.id(p.getProperty("Bnewbranchbutton"))).click();
		w.findElement(By.id(p.getProperty("Bname"))).sendKeys(bname);
		w.findElement(By.id(p.getProperty("Baddress"))).sendKeys(address);
		w.findElement(By.id(p.getProperty("Bzipcode"))).sendKeys(zipcode);
		new Select(w.findElement(By.id(p.getProperty("Bcountry")))).selectByVisibleText(country);
		new Select(w.findElement(By.id(p.getProperty("Bstate")))).selectByVisibleText(state);
		new Select(w.findElement(By.id(p.getProperty("Bcity")))).selectByVisibleText(city);
		Thread.sleep(3000);
		w.findElement(By.id(p.getProperty("Bsubmitbutton"))).click();
		Thread.sleep(3000);
		// Verifying if new  branch creation was successful
		String ActVal = w.switchTo().alert().getText();
		if (ActVal.contains(ExpVal)) 
		{
			System.out.println("Branch created successfully");
		} 
		else 
		{
			System.out.println("Branch already exists");
		}
		w.switchTo().alert().accept();
		Thread.sleep(3000);
		w.findElement(By.xpath(p.getProperty("Bhomebutton"))).click();
		return "Branch Creation: Pass and "+ActVal;
	}
	public String RoleCreation(String rname,String rtype) throws InterruptedException
	{
		ExpVal = "Sucessfully";
		w.findElement(By.xpath(p.getProperty("Rbutton"))).click();
		Thread.sleep(3000);
		w.findElement(By.id(p.getProperty("NRbutton"))).click();
		Thread.sleep(3000);
		w.findElement(By.id(p.getProperty("Rname"))).sendKeys(rname);
		new Select(w.findElement(By.id(p.getProperty("Rtype")))).selectByVisibleText(rtype);
		w.findElement(By.id(p.getProperty("Rsubmitbutton"))).click();
		Thread.sleep(3000);
		// Verifying if new  role creation was successful
		 ActVal = w.switchTo().alert().getText();
		if (ActVal.contains(ExpVal)) 
		{
			System.out.println("Role is created successfully");
		} 
		else 
		{
			System.out.println("The entered role already exists");
		}
		w.switchTo().alert().accept();
		Thread.sleep(3000);
		w.findElement(By.xpath(p.getProperty("Rhomebutton"))).click();
		return "Role Creation: Pass and "+ActVal;
	}
	public String EmpCreation(String ename,String epwd,String erole,String ebranch) throws InterruptedException
	{
		ExpVal = "Successfully";
		w.findElement(By.xpath(p.getProperty("Empbutton"))).click();
		Thread.sleep(3000);
		w.findElement(By.id(p.getProperty("NEmpbutton"))).click();
		w.findElement(By.id(p.getProperty("Empname"))).sendKeys(ename);
		w.findElement(By.id(p.getProperty("Emppwd"))).sendKeys(epwd);
		new Select(w.findElement(By.id(p.getProperty("Emprole")))).selectByVisibleText(erole);
		new Select(w.findElement(By.id(p.getProperty("Empbranch")))).selectByVisibleText(ebranch);
		Thread.sleep(3000);
		w.findElement(By.id(p.getProperty("Empsubmitbutton"))).click();
		Thread.sleep(3000);
		// Verifying if new  employee creation was successful
	     ActVal = w.switchTo().alert().getText();
		if (ActVal.contains(ExpVal)) 
		{
			System.out.println("New employee created successfully");
		} 
		else
		{
			System.out.println("Entered employee already exists");
		}
		w.switchTo().alert().accept();
		w.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		return "Employee Creation: Pass and "+ActVal;
	}
	public String Logout() throws InterruptedException  //Logout from Employee
	{
		Thread.sleep(3000);
		w.findElement(By.xpath(p.getProperty("Emplogoutbutton"))).click();
		return "Log out: Pass";
	}
	public String BLogin(String brname,String bid,String bpwd) throws InterruptedException
	{
		ExpVal = "Welcome to Admin";
		new Select(w.findElement(By.id(p.getProperty("Bankerbrname")))).selectByVisibleText(brname);
		Thread.sleep(3000);
		w.findElement(By.id(p.getProperty("BankerID"))).sendKeys(bid);
		Thread.sleep(3000);
		w.findElement(By.id(p.getProperty("Bankerpwd"))).sendKeys(bpwd);
		Thread.sleep(3000);
		w.findElement(By.id(p.getProperty("Bankerloginbutton"))).click();
		//Verifying if Banker login was successful
		 ActVal = w.findElement(By.xpath(p.getProperty("BankerActVal"))).getText();
		if (ActVal.contains(ExpVal)) 
		{
			System.out.println("Banker login was successful");
		} 
		else 
		{
			System.out.println("Banker login was not successful");
		}
		return "Banker Login: Pass and "+ActVal;
	}
	public String CloseApp()
	{
		w.quit();
		return "Close Application: Pass";
	}
	
	public String Employee_Home()
	{
		w.findElement(By.xpath(p.getProperty("Emphome"))).click();
		return "Employee Home: Pass";
	}
	public String Home_Logout()
	{
		w.findElement(By.xpath(p.getProperty("HLogout"))).click();
		return "Home Logout button: Pass";
	}
	 
		
	}


	
	

