package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleDetailspom
{
	@FindBy(id="btnRoles")
	WebElement newrole;

	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement rhome;

	public void RNrole()
	{
		newrole.click();
	}

	public void RHome()
	{
		rhome.click();
	}
}
