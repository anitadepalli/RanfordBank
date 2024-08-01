package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationpom 
{
	@FindBy(id="txtRname")
	WebElement rname;

	@FindBy(id="lstRtypeN")
	WebElement rtype;

	@FindBy(id="btninsert")
	WebElement submit;

	public void RCreation(String rolename,String roletype) throws InterruptedException
	{
		rname.sendKeys(rolename);
		Select RT=new Select(rtype);
		RT.selectByVisibleText(roletype);
		Thread.sleep(3000);
		submit.click();
	}
}
