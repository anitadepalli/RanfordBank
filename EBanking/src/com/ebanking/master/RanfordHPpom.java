package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RanfordHPpom
{
	// Element properties
	@FindBy(id="txtuId")
	WebElement uname;

	@FindBy(id="txtPword")
	WebElement pwd;

	@FindBy(id="login")
	WebElement lgn;

	@FindBy(id="drlist")
	WebElement bbr;
	
	//Element methods
	public void ALogin()
	{
		uname.sendKeys("Admin");
		pwd.sendKeys("Mindq@Sys");
		lgn.click();
	}
	public void BLogin()
	{
		Select BN= new Select(bbr);
		BN.selectByVisibleText("DutchBank");
		uname.sendKeys("AndyGibb");
		pwd.sendKeys("manager");
		lgn.click();
	}
	
	}



