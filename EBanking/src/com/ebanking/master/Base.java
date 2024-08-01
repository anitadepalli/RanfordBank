package com.ebanking.master;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class Base 
{
	Library l=new Library();

	@BeforeTest
	public void beforeTest() 
	{
		l.AdminLogin("Admin","Mindq@Sys");
	}

	@AfterTest
	public void afterTest() throws InterruptedException 
	{
		l.Home_Logout();
	}

	@BeforeSuite
	public void beforeSuite() throws IOException 
	{
		l.LaunchApp("http://103.211.39.246/ranford2");  
	}

	@AfterSuite
	public void afterSuite() 
	{
		l.CloseApp();
	}

}
