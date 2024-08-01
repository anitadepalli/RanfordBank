package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankerHP 
{
	@FindBy(xpath="//*[@id=\"IMG1\"]")
	WebElement bankerlogout;
	
	public void BLogout()
	{
		bankerlogout.click();
	}
}
