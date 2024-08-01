package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationpom
{
	@FindBy(id="txtUname")
	WebElement employeename;

	@FindBy(id="txtLpwd")
	WebElement loginpwd;

	@FindBy(id="lst_Roles")
	WebElement erole;

	@FindBy(id="lst_Branch")
	WebElement ebranch;

	@FindBy(id="BtnSubmit")
	WebElement submit;

	public void ECreation(String empname,String emppwd,String emprole,String empbranch)
	{
		employeename.sendKeys(empname);	
		loginpwd.sendKeys(emppwd);
		Select Erole=new Select(erole);
		Erole.selectByVisibleText(emprole);
		Select Ebranch=new Select(ebranch);
		Ebranch.selectByVisibleText(empbranch);
		submit.click();
	}

}
