package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AdminHPpom
{
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")
	WebElement branch;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
	WebElement role;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")
	WebElement employee;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")
	WebElement logout;

	public void ABranch()
	{
		branch.click();
	}
	public void ARole()
	{
		role.click();
	}
	public void AEmployee()
	{
		employee.click();
	}
	public void ALogout()
	{
		logout.click();
	}
	
}
