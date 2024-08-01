package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BranchDetailspom 
{
	@FindBy(id="BtnNewBR")
	WebElement newbranch;

	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement bhome;

	public void BNbranch()
	{
		newbranch.click();
	}
	public void BHome()
	{
		bhome.click();
	}
}
