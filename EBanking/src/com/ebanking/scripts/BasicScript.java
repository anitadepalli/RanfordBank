package com.ebanking.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicScript 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver w=new FirefoxDriver();
		w.manage().window().maximize();
		String ExpVal = "Ranford Bank";
		w.get("http://103.211.39.246/ranford2");
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		// Verifying if the right page is displayed
		String ActVal = w.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		if (ExpVal.equalsIgnoreCase(ActVal)) 
		{
			System.out.println("Webpage launch was successful");
		} 
		else 
		{
			System.out.println("Webpage launch was not successful");
		}
	    // Admin Login
		String ExpVal1 = "Welcome to Admin";
		w.findElement(By.id("txtuId")).sendKeys("Admin");
		w.findElement(By.id("txtPword")).sendKeys("Mindq@Sys");
		w.findElement(By.xpath("//input[@id='login']")).click();
		//Verifying if Admin login was successful
		String ActVal1 = w.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		if (ExpVal1.equalsIgnoreCase(ActVal1)) 
		{
			System.out.println("Admin login was successful");
		} 
		else
		{
			System.out.println("Admin login was not successful");
		}
		Thread.sleep(3000);
		// Create a new branch
		String ExpVal2 = "Sucessfully";
		w.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		w.findElement(By.id("BtnNewBR")).click();
		w.findElement(By.id("txtbName")).sendKeys("DC431Alfa");
		w.findElement(By.id("txtAdd1")).sendKeys("Bradford Rd");
		w.findElement(By.id("txtZip")).sendKeys("32714");
		new Select(w.findElement(By.id("lst_counrtyU"))).selectByVisibleText("USA");
		new Select(w.findElement(By.id("lst_stateI"))).selectByVisibleText("Washington");
		new Select(w.findElement(By.id("lst_cityI"))).selectByVisibleText("Olympia");
		Thread.sleep(3000);
		w.findElement(By.id("btn_insert")).click();
		Thread.sleep(3000);
		// Verifying if new  branch creation was successful
		String ActVal2 = w.switchTo().alert().getText();
		if (ActVal2.contains(ExpVal2)) 
		{
			System.out.println("Branch created successfully");
		} 
		else 
		{
			System.out.println("Branch already exists");
		}
		w.switchTo().alert().accept();
		Thread.sleep(3000);
		w.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
        // Role creation
		String ExpVal3 = "Sucessfully";
		w.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		Thread.sleep(3000);
		w.findElement(By.id("btnRoles")).click();
		Thread.sleep(3000);
		w.findElement(By.id("txtRname")).sendKeys("Cashier");
		new Select(w.findElement(By.id("lstRtypeN"))).selectByVisibleText("E");
		w.findElement(By.id("btninsert")).click();
		Thread.sleep(3000);
		// Verifying if new  role creation was successful
		String ActVal3 = w.switchTo().alert().getText();
		if (ActVal3.contains(ExpVal3)) 
		{
			System.out.println("Role is created successfully");
		} 
		else 
		{
			System.out.println("The entered role already exists");
		}
		w.switchTo().alert().accept();
		Thread.sleep(3000);
		w.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		//Employee Creation
		String ExpVal4 = "Successfully";
		w.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		Thread.sleep(3000);
		w.findElement(By.id("BtnNew")).click();
		w.findElement(By.id("txtUname")).sendKeys("AndyGibb");
		w.findElement(By.id("txtLpwd")).sendKeys("manager");
		new Select(w.findElement(By.id("lst_Roles"))).selectByVisibleText("banker");
		new Select(w.findElement(By.id("lst_Branch"))).selectByVisibleText("DutchBank");
		Thread.sleep(3000);
		w.findElement(By.id("BtnSubmit")).click();
		Thread.sleep(3000);
		// Verifying if new  employee creation was successful
		String ActVal4 = w.switchTo().alert().getText();
		if (ActVal4.contains(ExpVal4)) 
		{
			System.out.println("New employee created successfully");
		} 
		else
		{
			System.out.println("Entered employee already exists");
		}
		w.switchTo().alert().accept();
		Thread.sleep(3000);
		w.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[3]/a/img")).click();
		Thread.sleep(3000);
		//Banker Login
		String ExpVal5 = "Welcome to Admin";
		new Select(w.findElement(By.id("drlist"))).selectByVisibleText("ATLBRANCH");
		Thread.sleep(3000);
		w.findElement(By.id("txtuId")).sendKeys("Admin");
		Thread.sleep(3000);
		w.findElement(By.id("txtPword")).sendKeys("Mindq@Sys");
		Thread.sleep(3000);
		w.findElement(By.id("login")).click();
		//Verifying if Banker login was successful
		String ActVal5 = w.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		if (ActVal5.contains(ExpVal5)) 
		{
			System.out.println("Banker login was successful");
		} 
		else 
		{
			System.out.println("Banker login was not successful");
		}
		
		


	}

}
